package com.khanchych.sandbox.osgi.telegrambot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetMe;
import com.pengrad.telegrambot.response.BaseResponse;
import okhttp3.OkHttpClient;
import okhttp3.Response;


public class TelegramBotClass {
    private final static String URL_FORMAT = "https://api.telegram.org/bot%s/";
    private final static String TOKEN = "472849068:AAHB7Mj-9Ejyuyzoij2NxbolV757WfdFwTg";
    private final static String URL = String.format(URL_FORMAT, TOKEN);
    private final static OkHttpClient okHttpClient = new OkHttpClient();
    private final static TelegramBot bot = TelegramBotAdapter.buildCustom(TOKEN, okHttpClient);

    public static void main(String[] args) {
        BaseRequest request = new GetMe();
        BaseResponse response = bot.execute(request);

        System.out.println(response);
    }
}
