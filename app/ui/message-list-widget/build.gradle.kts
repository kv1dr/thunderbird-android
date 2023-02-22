plugins {
    id "thunderbird.library.android"
}

dependencies {
    implementation project(":app:ui:legacy")
    implementation project(":app:core")

    implementation libs.timber
}

android {
    namespace 'app.k9mail.ui.widget.list'

    buildFeatures {
        buildConfig true
    }

    buildTypes {
        debug {
            manifestPlaceholders = ['appAuthRedirectScheme': 'FIXME: override this in your app project']
        }
        release {
            manifestPlaceholders = ['appAuthRedirectScheme': 'FIXME: override this in your app project']
        }
    }
}
