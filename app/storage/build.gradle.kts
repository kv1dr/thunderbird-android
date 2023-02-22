plugins {
    id "thunderbird.library.android"
}

dependencies {
    api libs.koin.core

    implementation project(":app:core")
    implementation libs.androidx.core.ktx
    implementation libs.timber
    implementation libs.mime4j.core
    implementation libs.commons.io
    implementation libs.moshi

    testImplementation project(':mail:testing')
    testImplementation project(':app:testing')
    testImplementation libs.robolectric
    testImplementation libs.commons.io
}

android {
    namespace 'com.fsck.k9.storage'
}
