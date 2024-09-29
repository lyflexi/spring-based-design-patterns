package org.lyflexi.strategypattern.strategyByHandsFactory.enums;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:27
 */
public enum StrategyFactoryType {
    TYPE_A("TYPE_A", "Strategy A"),
    TYPE_B("TYPE_B", "Strategy B");

    private String identifier;
    private String description;

    StrategyFactoryType(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public static StrategyFactoryType fromIdentifier(String identifier) {
        for (StrategyFactoryType strategyFactoryType : values()) {
            if (strategyFactoryType.identifier.equals(identifier)) {
                return strategyFactoryType;
            }
        }
        throw new IllegalArgumentException("No StrategyType with identifier: " + identifier);
    }
}