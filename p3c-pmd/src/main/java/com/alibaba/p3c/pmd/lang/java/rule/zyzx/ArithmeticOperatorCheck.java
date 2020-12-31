package com.alibaba.p3c.pmd.lang.java.rule.zyzx;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.*;
import org.jaxen.JaxenException;

import java.util.List;

/**
 * @author qinzhibin
 */

public class ArithmeticOperatorCheck extends AbstractAliRule {

    public static final String SAME_COMPUTER ="//BlockStatement/Statement/StatementExpression/AssignmentOperator";
    public static final String ADD_COMPUTER ="//BlockStatement/Statement/StatementExpression/Expression/UnaryExpression[@Image=\"+\"]";

    @Override
    public Object visit(ASTStatementExpression node, Object data) {
        try{
            List<Node> markerAnnotations = node.findChildNodesWithXPath(SAME_COMPUTER);
            List<Node> markerAnnotations2 = node.findChildNodesWithXPath(ADD_COMPUTER);
            for(int i = 0 ;i<markerAnnotations.size();i++){
                for(int j =0;j<markerAnnotations2.size();j++){
                    int b1 = markerAnnotations.get(i).getBeginLine();
                    int b2 = markerAnnotations2.get(j).getBeginLine();
                    int b3 = markerAnnotations.get(i).getBeginColumn();
                    int b4 = markerAnnotations2.get(j).getBeginColumn();

                    if(b1 == b2 && b4 - b3 < 3 && b4 - b3 > 0){
                        addViolationWithMessage(data,node,"java.zyzx.ArithmeticOperatorCheck.violation.msg",null);
                    }
                }
            }
        }catch (JaxenException e){
            e.printStackTrace();
        }
        return super.visit(node, data);
    }

}