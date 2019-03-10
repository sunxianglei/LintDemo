package com.example.lintjar.detector;

import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;
import com.intellij.psi.PsiMethod;
import com.sun.xml.bind.v2.model.core.ID;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UCallExpression;
import org.omg.CORBA.StringHolder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LSLogDetector extends Detector implements Detector.UastScanner {

    private static final String ID = "LsLog";
    private static final String DESCRIPTION = "避免使用系统级的Log或print";
    private static final String EXPLANATION = "使用项目框架内的LsLog";
    private static final Category CATEGORY = Category.SECURITY;
    private static final int PRIORITY = 5;
    private static final Severity SEVERITY = Severity.ERROR;
    private static final Implementation IMPLEMENTATION =
            new Implementation(LSLogDetector.class, Scope.JAVA_FILE_SCOPE);

    public static final Issue ISSUE = Issue.create(
            ID,
            DESCRIPTION,
            EXPLANATION,
            CATEGORY,
            PRIORITY,
            SEVERITY,
            IMPLEMENTATION
    );

    @Nullable
    @Override
    public List<String> getApplicableMethodNames() {
        return Arrays.asList("v","d","i","e","w", "System.out.println","System.out.print");
    }

    @Override
    public void visitMethod(@NotNull JavaContext context, @NotNull UCallExpression node, @NotNull PsiMethod method) {
        context.report(ISSUE, context.getLocation(method), EXPLANATION);
    }

}
