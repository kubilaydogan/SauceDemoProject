# Sauce Demo Project
This framework is created by `Kubilay Dogan` for demo purposes.

## Main dependencies
- Java 17
- Selenium 3.141.59
- Cucumber 6.11.0
- Junit 5.8.1


## Supported reporting
Framework provides 3 different reports:
* [Extent reports](test-output/Spark/ExtentSpark.html)
* [Pdf](test-output/Pdf/ExtentPdf.pdf)
* [Cucumber HTML report](target/cucumber-html-reports/overview-features.html)

To generate reports, use:
```
mvn verify
```
And the result should be as follows:
```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.484 s
[INFO] Finished at: 2021-10-27T14:22:32-04:00
[INFO] ------------------------------------------------------------------------

```

## Project structure

#### Feature files

Feature files are located in the [resources/Features](src/test/resources/Features) directory.

#### Step classes

Steps definitions are located in [StepDefinitions](src/test/java/StepDefinitions) package.

#### Page Object Model

Pages and components definition can be found under [Pages](src/test/java/Pages) package.

## Logging
[Logs](logs/automation.log) are created under logs package by using 
* apache.logging.log4j
* slf4j-api
