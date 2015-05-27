package com.kalessil.phpStorm.phpInspectionsEA.inspectors.regularExpressions.modifiersStrategy;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.openapi.util.text.StringUtil;
import com.jetbrains.php.lang.psi.elements.StringLiteralExpression;
import org.jetbrains.annotations.NotNull;

public class DeprecatedModifiersCheckStrategy {
    private static final String strProblemDescription = "'e' modifier is deprecated, please use 'preg_replace_callback()' instead";

    static public void apply(final String modifiers, @NotNull final StringLiteralExpression target, @NotNull final ProblemsHolder holder) {
        if (!StringUtil.isEmpty(modifiers) && modifiers.indexOf('e') >= 0) {
            holder.registerProblem(target, strProblemDescription, ProblemHighlightType.GENERIC_ERROR);
        }
    }
}
