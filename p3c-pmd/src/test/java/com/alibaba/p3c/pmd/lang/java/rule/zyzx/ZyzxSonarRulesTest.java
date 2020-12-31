package com.alibaba.p3c.pmd.lang.java.rule.zyzx;

import net.sourceforge.pmd.Rule;
import net.sourceforge.pmd.testframework.SimpleAggregatorTst;
import org.junit.Test;

public class ZyzxSonarRulesTest extends SimpleAggregatorTst {
    private static final String RULESET = "java-zyzx-sonar";

    @Override
    public void setUp(){
        addRule(RULESET,"MethodParameterCountRule");
        addRule(RULESET,"ArithmeticOperatorCheck");
        addRule(RULESET,"SillyEqualsCheck");
    }

    @Test
    public void testMethodParameterCountRule(){
        Rule rule = this.findRule(RULESET,"MethodParameterCountRule");
        runTests(rule,"MethodParameterCountRule");
    }

    @Test
    public void testArithmeticOperatorCheck(){
        Rule rule = this.findRule(RULESET,"ArithmeticOperatorCheck");
        runTests(rule,"ArithmeticOperatorCheck");
    }

//    @Test
//    public void testPrintStackTraceCalledWithoutArgumentCheck(){
//        Rule rule = this.findRule(RULESET,"PrintStackTraceCalledWithoutArgumentCheck");
//        runTests(rule,"PrintStackTraceCalledWithoutArgumentCheck");
//    }

    @Test
    public void testSillyEqualsCheck(){
        Rule rule = this.findRule(RULESET,"SillyEqualsCheck");
        runTests(rule,"SillyEqualsCheck");
    }

}
