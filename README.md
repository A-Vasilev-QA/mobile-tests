# Tests for Wikipedia Android aplication alpha
https://github.com/wikimedia/apps-android-wikipedia/

# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/C12-AVasilevQA-Mobile-Tests-12/">https://jenkins.autotests.cloud/job/C12-AVasilevQA-Mobile-Tests-12/</a>

Also can be used for local tests with emulator or real device

# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* device (default "Google Pixel 4"")
* osVersion (Default 10.0)


Run tests with filled remote.properties:
```bash
gradle clean :test --tests "qa.avasilev.tests.MoibileTests"
```

Serve report:
```bash
allure serve build/allure-results
