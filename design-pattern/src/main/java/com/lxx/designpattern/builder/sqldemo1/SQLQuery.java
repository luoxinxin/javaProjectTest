package com.lxx.designpattern.builder.sqldemo1;

/**
 * 建造者模式 创建动态sql
 */
public class SQLQuery {
    private String select;
    private String from;
    private String where;

    private SQLQuery(Builder builder) {
        this.select = builder.select;
        this.from = builder.from;
        this.where = builder.where;
    }

    @Override
    public String toString() {
        StringBuilder query = new StringBuilder();
        query.append(select).append(" ");
        query.append(from).append(" ");
        if (where != null && !where.isEmpty()) {
            query.append(where);
        }
        return query.toString();
    }

    public static class Builder {
        private String select;
        private String from;
        private String where = "";

        public Builder select(String select) {
            this.select = select;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder where(String condition) {
            if (where.isEmpty()) {
                this.where = "WHERE " + condition;
            } else {
                this.where += " AND " + condition;
            }
            return this;
        }

        public SQLQuery build() {
            return new SQLQuery(this);
        }
    }
}
