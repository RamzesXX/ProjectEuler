package mbeans;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import java.util.Date;

public class Cassandralog implements CassandralogMBean {
    private static final String LOG_TEMPLATE = "INSERT INTO tutor.log(event_time, user, message) VALUES(?,?,?)";
    private Session session;

    public Cassandralog(Session session) {
        this.session = session;
    }

    public void log(String user, String message) {
        BoundStatement statement = session.prepare(LOG_TEMPLATE).bind(new Date(), user, message);
        session.execute(statement);
    }
}
