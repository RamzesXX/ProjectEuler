import com.datastax.driver.core.Cluster;
import mbeans.Cassandralog;
import mbeans.CassandralogMBean;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class CassandraTutorial {
    public static void main(String[] args) {
//        cassandraWithBean();
    }

    private static void cassandraWithBean() throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
        Cluster cluster = Cluster.builder()
                .addContactPoint("192.168.99.100")
                .withCredentials("user1","user1")
                .build();

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("mbeans:type=Cassandralog");
        CassandralogMBean cassandralog = new Cassandralog(cluster.connect());
        server.registerMBean(cassandralog, objectName);
        cassandralog.log("user", "bla");
        Thread.sleep(300000);

        cluster.close();
    }
}
