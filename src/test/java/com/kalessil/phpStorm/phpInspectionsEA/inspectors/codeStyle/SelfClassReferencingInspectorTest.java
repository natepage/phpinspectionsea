package com.kalessil.phpStorm.phpInspectionsEA.inspectors.codeStyle;

import com.intellij.codeInsight.intention.IntentionAction;
import com.kalessil.phpStorm.phpInspectionsEA.PhpCodeInsightFixtureTestCase;

final public class SelfClassReferencingInspectorTest extends PhpCodeInsightFixtureTestCase {
    public void testDefault() {
        final SelfClassReferencingInspector selfClassReferencingInspector = new SelfClassReferencingInspector();
        selfClassReferencingInspector.PREFER_CLASS_NAMES = false;

        myFixture.enableInspections(selfClassReferencingInspector);

        myFixture.configureByFile("fixtures/codeStyle/self-class-referencing.php");
        myFixture.testHighlighting(true, false, true);

        for (final IntentionAction fix : myFixture.getAllQuickFixes()) {
            myFixture.launchAction(fix);
        }

        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("fixtures/codeStyle/self-class-referencing.fixed.php");
    }

    public void testReverse() {
        final SelfClassReferencingInspector selfClassReferencingInspector = new SelfClassReferencingInspector();
        selfClassReferencingInspector.PREFER_CLASS_NAMES = true;

        myFixture.enableInspections(selfClassReferencingInspector);

        myFixture.configureByFile("fixtures/codeStyle/self-class-referencing.reverse.php");
        myFixture.testHighlighting(true, false, true);

        for (final IntentionAction fix : myFixture.getAllQuickFixes()) {
            myFixture.launchAction(fix);
        }

        myFixture.setTestDataPath(".");
        myFixture.checkResultByFile("fixtures/codeStyle/self-class-referencing.reverse.fixed.php");
    }
}
