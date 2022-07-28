# mobile-tests-12

# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/C12-AVasilevQA-Mobile-Tests-12/">https://jenkins.autotests.cloud/job/C12-AVasilevQA-Mobile-Tests-12/</a>


# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* device (default "Google Pixel 6"")
* osVersion (Default 9.0)


Run tests with filled remote.properties:
```bash
gradle clean :test --tests "qa.avasilev.tests.SearchTests"
```

Serve report:
```bash
allure serve build/allure-results