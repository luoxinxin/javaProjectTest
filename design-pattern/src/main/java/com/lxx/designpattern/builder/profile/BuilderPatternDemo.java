package com.lxx.designpattern.builder.profile;

import org.json.JSONObject;

/**
 * 生成复杂的配置文件，如JSON或XML格式的配置文件
 */

class ConfigBuilder {
    private JSONObject config;

    public ConfigBuilder() {
        config = new JSONObject();
    }

    public ConfigBuilder addDatabaseConfig(String host, int port, String dbName) {
        JSONObject dbConfig = new JSONObject();
        dbConfig.put("host", host);
        dbConfig.put("port", port);
        dbConfig.put("dbName", dbName);
        config.put("database", dbConfig);
        return this;
    }

    public ConfigBuilder addServerConfig(String host, int port) {
        JSONObject serverConfig = new JSONObject();
        serverConfig.put("host", host);
        serverConfig.put("port", port);
        config.put("server", serverConfig);
        return this;
    }

    public String build() {
        return config.toString(4);  // Pretty print with indentation
    }
}

// 客户端代码
public class BuilderPatternDemo {
    public static void main(String[] args) {
        String config = new ConfigBuilder()
                .addDatabaseConfig("localhost", 3306, "mydb")
                .addServerConfig("localhost", 8080)
                .build();

        System.out.println(config);
    }
}
