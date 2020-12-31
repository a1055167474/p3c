package com.alibaba.p3c.pmd.lang.java.rule.zyzx;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTCatchStatement;
import org.jaxen.JaxenException;

import java.util.List;

/**
 * @author qinzhibin
 */
//public class PrintStackTraceCalledWithoutArgumentCheck extends AbstractAliRule {
//    private static final String CHECKMETHODNUM = "//Block/BlockStatement/Statement/TryStatement/CatchStatement[./Block/BlockStatement/Statement/StatementExpression/PrimaryExpression/PrimaryPrefix/Name[ends-with(@Image,'.printStackTrace')]]";
//
//    @Override
//    public Object visit(ASTCatchStatement node , Object data){
//        try{
//            List<Node> markerAnnotations = node.findChildNodesWithXPath(CHECKMETHODNUM);
//            if (!markerAnnotations.isEmpty() ){
//                addViolationWithMessage(data,node,
//                        "java.zyzx.PrintStackTraceCalledWithoutArgumentCheck.rule.msg",null);
//            }
//        }catch (JaxenException e){
//            throw new RuntimeException("XPath expression " + CHECKMETHODNUM + " failed: " + e.getLocalizedMessage(),e);
//        }
//        return super.visit(node , data);
//    }
//
//
//}



