package com.example.lintjar.detector;

import com.android.tools.lint.client.api.UElementHandler;
import com.android.tools.lint.detector.api.Category;
import com.android.tools.lint.detector.api.Detector;
import com.android.tools.lint.detector.api.Implementation;
import com.android.tools.lint.detector.api.Issue;
import com.android.tools.lint.detector.api.JavaContext;
import com.android.tools.lint.detector.api.Scope;
import com.android.tools.lint.detector.api.Severity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.uast.UElement;
import org.jetbrains.uast.ULiteralExpression;
import org.jetbrains.uast.UastLiteralUtils;

import java.util.Collections;
import java.util.List;

public class SampleDetector extends Detector implements Detector.UastScanner {

    public static final Issue ISSUE = Issue.create(
            "lintTip",
            "lint提示",
            "只是一个测试包含lint的字面量",
            Category.MESSAGES,
            6,
            Severity.WARNING,
            new Implementation(SampleDetector.class, Scope.JAVA_FILE_SCOPE)
    );

    @Nullable
    @Override
    public List<Class<? extends UElement>> getApplicableUastTypes() {
        return Collections.singletonList(ULiteralExpression.class);
    }

    @Nullable
    @Override
    public UElementHandler createUastHandler(@NotNull JavaContext context) {
        return new UElementHandler(){
            @Override
            public void visitLiteralExpression(@NotNull ULiteralExpression node) {
                String str = UastLiteralUtils.getValueIfStringLiteral(node);
                if(str == null){
                    return;
                }
                if(str.contains("lint")){
                    context.report(ISSUE, context.getLocation(node), "xxxx");
                }
            }
        };/*sunxianglei and xiafangfang*/
    }/*forever love*/
            /*xixixixixixixixixixixixixixixixi*/
}
