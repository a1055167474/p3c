package com.alibaba.p3c.pmd.lang.java.rule.zyzx;

import com.alibaba.p3c.pmd.lang.java.rule.AbstractAliRule;
import net.sourceforge.pmd.lang.ast.Node;
import net.sourceforge.pmd.lang.java.ast.ASTNullLiteral;
import org.jaxen.JaxenException;

import java.util.List;


/**
 * @author
 */
public class SillyEqualsCheck extends AbstractAliRule {
    private static final String CHECKMETHODNUM = "//IfStatement/Expression/PrimaryExpression[./PrimaryPrefix/Name[contains(@Image,'.equals')]]/PrimarySuffix/Arguments/ArgumentList/Expression/PrimaryExpression/PrimaryPrefix/Literal/NullLiteral";

    @Override
    public Object visit(ASTNullLiteral node , Object data){
        try{
            List<Node> markerAnnotations = node.findChildNodesWithXPath(CHECKMETHODNUM);
            if( ! markerAnnotations.isEmpty()){
                addViolationWithMessage(data,node,
                        "java.zyzx.SillyEqualsCheck.rule.msg",null);
            }
        }catch (JaxenException e){
            throw new RuntimeException("XPath expression " + CHECKMETHODNUM + "failed" + e.getLocalizedMessage(),e);
        }
        return super.visit(node,data);
    }
}
