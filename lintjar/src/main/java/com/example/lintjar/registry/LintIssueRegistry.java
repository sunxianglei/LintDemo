package com.example.lintjar.registry;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.Issue;
import com.example.lintjar.detector.LSLogDetector;
import com.example.lintjar.detector.SampleDetector;

import java.util.Arrays;
import java.util.List;

public class LintIssueRegistry extends IssueRegistry {
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                LSLogDetector.ISSUE,
                SampleDetector.ISSUE);
    }
}
