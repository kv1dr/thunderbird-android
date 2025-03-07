import com.diffplug.gradle.spotless.SpotlessExtension

plugins {
    id("com.diffplug.spotless")
}

configure<SpotlessExtension> {
    kotlin {
        target(
            "src/*/java/*.kt",
            "src/*/kotlin/*.kt",
            "src/*/java/**/*.kt",
            "src/*/kotlin/**/*.kt",
        )

        ktlint(libs.versions.ktlint.get())
            .setEditorConfigPath("${project.rootProject.projectDir}/.editorconfig")
            .editorConfigOverride(kotlinEditorConfigOverride)
    }

    kotlinGradle {
        target(
            "*.gradle.kts",
        )

        ktlint(libs.versions.ktlint.get())
            .setEditorConfigPath("${project.rootProject.projectDir}/.editorconfig")
            .editorConfigOverride(
                mapOf(
                    "ktlint_standard_function-signature" to "disabled",
                    "ktlint_code_style" to "intellij_idea",
                ),
            )
    }

    flexmark {
        target(
            "*.md",
        )
        flexmark()
    }

    format("misc") {
        target(".gitignore")
        trimTrailingWhitespace()
    }
}
