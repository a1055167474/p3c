package com.alibaba.p3c.pmd.lang.java.rule.zyzx;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import jdk.internal.org.objectweb.asm.tree.MethodNode;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTCompilationUnit;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameter;
import net.sourceforge.pmd.lang.java.ast.ASTFormalParameters;

import java.util.List;

/**
 * [Mandatory] Magic values, except for predefined, are forbidden in coding.
 *
 * @author qinzhibin
 * @date 2020/10/15
 */
public class MethodParameterCountRule extends AbstractAliRule {
    private static final String METHOD_XPATH="//MethodDeclarator";
    private static final Integer PARAMETER_COUNT_LIMIT = 8;

    @Override
    public Object visit(ASTCompilationUnit node, Object data) {
        try {
            List<Node> methodNodes = node.findChildNodesWithXPath(METHOD_XPATH);
            if(methodNodes!=null && methodNodes.size()>0){
                for(Node methodNode : methodNodes){
                    List<ASTFormalParameters> formalParameters = methodNode.findChildrenOfType(ASTFormalParameters.class);
                    if(formalParameters.get(0).getParameterCount() >= PARAMETER_COUNT_LIMIT){
                        addViolationWithMessage(data,methodNode,
                                "java.zyzx.MethodParameterCountRule.violation.msg",
                                new Object[]{methodNode.getImage()});
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.visit(node, data);
    }
}
