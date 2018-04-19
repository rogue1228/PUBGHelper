object Versions {
    const val anko = "0.10.4"
    const val arch = "1.1.1"
    const val support = "27.1.0"
    const val dagger = "2.11"
    const val junit = "4.12"
    const val espresso = "3.0.1"
    const val retrofit = "2.3.0"
    const val okhttp_logging_interceptor = "3.9.0"
    const val mockwebserver = "3.8.1"
    const val apache_commons = "2.5"
    const val mockito = "2.9.0"
    const val mockito_all = "1.10.19"
    const val dexmaker = "2.2.0"
    const val constraint_layout = "1.1.0-beta5"
    const val glide = "4.5.0"
    const val timber = "4.5.1"
    const val android_gradle_plugin = "3.0.1"
    const val rxjava2 = "2.1.3"
    const val rx_android = "2.0.1"
    const val rxkotlin2 = "2.1.0"
    const val rollbar = "0.2.1"
    const val gson = "2.8.2"
    const val atsl_runner = "1.0.1"
    const val atsl_rules = "1.0.1"
    const val hamcrest = "1.3"
    const val kotlin = "1.2.31"
    const val paging = "1.0.0"
    const val jodatime = "2.9.9"
    const val fotoapparat = "1.4.1"
    const val guava = "23.6-android"
    const val multidex = "1.0.2"
    const val assertJ = "1.7.1"
    const val robolectric = "3.1.1"
}

object Deps {

    //android
    const val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"

    //support
    const val support_exifinterface = "com.android.support:exifinterface:${Versions.support}"
    const val support_annotations = "com.android.support:support-annotations:${Versions.support}"
    const val support_app_compat = "com.android.support:appcompat-v7:${Versions.support}"
    const val support_recyclerview = "com.android.support:recyclerview-v7:${Versions.support}"
    const val support_cardview = "com.android.support:cardview-v7:${Versions.support}"
    const val support_design = "com.android.support:design:${Versions.support}"
    const val support_v4 = "com.android.support:support-v4:${Versions.support}"
    const val support_core_utils = "com.android.support:support-core-utils:${Versions.support}"
    const val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_layout}"

    //room
    const val room_runtime = "android.arch.persistence.room:runtime:${Versions.arch}"
    const val room_compiler = "android.arch.persistence.room:compiler:${Versions.arch}"
    const val room_rxjava2 = "android.arch.persistence.room:rxjava2:${Versions.arch}"
    const val room_testing = "android.arch.persistence.room:testing:${Versions.arch}"

    //anko
    const val anko = "org.jetbrains.anko:anko:${Versions.anko}"
    const val anko_constraint = "org.jetbrains.anko:anko-constraint-layout:${Versions.anko}"
    const val anko_design = "org.jetbrains.anko:anko-design:${Versions.anko}"
    const val anko_appcompat_v7 = "org.jetbrains.anko:anko-appcompat-v7:${Versions.anko}"
    const val anko_recyclerview = "org.jetbrains.anko:anko-recyclerview-v7:${Versions.anko}"

    //lifecycle
    const val lifecycler_extensions = "android.arch.lifecycle:extensions:${Versions.arch}"
    const val lifecycler_java8 = "android.arch.lifecycle:common-java8:${Versions.arch}"
    const val lifecycler_compiler = "android.arch.lifecycle:compiler:${Versions.arch}"

    const val arch_core_testing = "android.arch.core:core-testing:${Versions.arch}"

    //refrofit
    const val retrofit_runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofit_mock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"
    const val retrofit_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"

    //dagger2
    const val dagger_runtime = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger_android_support_compiler = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    //espresso
    const val espress_core = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val espress_contrib = "com.android.support.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espress_intents = "com.android.support.test.espresso:espresso-intents:${Versions.espresso}"

    //android test runner
    const val atsl_runner = "com.android.support.test:runner:${Versions.atsl_runner}"
    const val atsl_rules = "com.android.support.test:rules:${Versions.atsl_runner}"

    //mockito
    const val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_all = "org.mockito:mockito-all:${Versions.mockito_all}"

    //kotlin
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
    const val kotlin_test = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    //glide
    const val glide_runtime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compile = "com.github.bumptech.glide:compiler:${Versions.glide}"

    //google
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val guava = "com.google.guava:guava:${Versions.guava}"

    //reactivex
    const val rxjava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"
    const val rxkotlin2 = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin2}"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"

    const val jodatime = "net.danlew:android.joda:${Versions.jodatime}"
    const val fotoapparat = "io.fotoapparat.fotoapparat:library:${Versions.fotoapparat}"
    const val multidex = "com.android.support:multidex:${Versions.multidex}"
    const val rollbar = "com.rollbar:rollbar-android:${Versions.rollbar}"

    //for test
    const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"
    const val junit = "junit:junit:${Versions.junit}"
}

object Configs {
    const val min_sdk = 21
    const val compile_sdk = 27
    const val target_sdk = 26
    const val build_tools = "27.0.3"
    const val version_code = 124
    const val version_name = "2.9.30"

    const val dev_api_url = "\"http://dev.washon.co/\""
    const val live_api_url = "\"http://api.washon.co/\""
}

