package com.lxx.designpattern.builder.sqldemo3;

import java.util.ArrayList;
import java.util.List;

public class SQLQuery {
    private String select;
    private String from;
    private String where;
    private String orderBy;
    private String groupBy;
    private String having;
    private String limit;
    private List<Object> parameters;

    private SQLQuery(Builder builder) {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
        this.orderBy = builder.orderBy;
        this.groupBy = builder.groupBy;
        this.having = builder.having;
        this.limit = builder.limit;
        this.parameters = builder.parameters;
    }

    public String getQuery() {
        StringBuilder query = new StringBuilder();
        query.append(select).append(" ");
        query.append(from).append(" ");
        if (where != null && !where.isEmpty()) {
            query.append(where).append(" ");
        }
        if (groupBy != null && !groupBy.isEmpty()) {
            query.append(groupBy).append(" ");
        }
        if (having != null && !having.isEmpty()) {
            query.append(having).append(" ");
        }
        if (orderBy != null && !orderBy.isEmpty()) {
            query.append(orderBy).append(" ");
        }
        if (limit != null && !limit.isEmpty()) {
            query.append(limit);
        }
        return query.toString();
    }

    public List<Object> getParameters() {
        return parameters;
    }

    public static class Builder {
        private String select;
        private String from;
        private String where = "";
        private String orderBy = "";
        private String groupBy = "";
        private String having = "";
        private String limit = "";
        private List<Object> parameters = new ArrayList<>();

        public Builder select(String select) {
            this.select = select;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder where(String column, String operator, Object value) {
            if (where.isEmpty()) {
                this.where = "WHERE " + column + " " + operator + " ?";
            } else {
                this.where += " AND " + column + " " + operator + " ?";
            }
            this.parameters.add(value);
            return this;
        }

        public Builder orderBy(String orderBy) {
            this.orderBy = "ORDER BY " + orderBy;
            return this;
        }

        public Builder groupBy(String groupBy) {
            this.groupBy = "GROUP BY " + groupBy;
            return this;
        }

        public Builder having(String having) {
            this.having = "HAVING " + having;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = "LIMIT " + limit;
            return this;
        }

        public SQLQuery build() {
            return new SQLQuery(this);
        }
    }
}
