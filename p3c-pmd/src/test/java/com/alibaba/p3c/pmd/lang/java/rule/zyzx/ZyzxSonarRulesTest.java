package com.alibaba.p3c.pmd.lang.java.rule.zyzx;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.testframework.SimpleAggregatorTst;
import org.junit.Test;

public class ZyzxSonarRulesTest extends SimpleAggregatorTst {
    private static final String RULESET = "java-zyzx-sonar";

    @Override
    public void setUp(){
        addRule(RULESET,"MethodParameterCountRule");
    }

    @Test
    public void testMethodParameterCountRule(){
        Rule rule = this.findRule(RULESET,"MethodParameterCountRule");
        runTests(rule,"MethodParameterCountRule");
    }

}
