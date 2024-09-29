package org.lyflexi.strategypattern.strategyByInitializingBean.enums;

/**
 * @Description:
 * @Author: lyflexi
 * @project: spring-practice
 * @Date: 2024/9/13 22:27
 */
public enum StrategyInitializeType {
    TYPE_A("TYPE_A", "Strategy A"),
    TYPE_B("TYPE_B", "Strategy B");

    private String identifier;
    private String description;

    StrategyInitializeType(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }

    public static StrategyInitializeType fromIdentifier(String identifier) {
        for (StrategyInitializeType strategyInitializeType : values()) {
            if (strategyInitializeType.identifier.equals(identifier)) {
                return strategyInitializeType;
            }
        }
        throw new IllegalArgumentException("No StrategyType with identifier: " + identifier);
    }
}