# Sauce Demo Project
## Başlıklar

metinlerimiz
- Java 17
- Selenium 3.141.59
- Cucumber 7.0.0

`gri alan`

### Alt başlık

```
{
  daha geniş çaplı kodlamalar
}
```

#### Java 17

- JDK 17 yeni sürüm 
- download [Maven](https://maven.apache.org/download.cgi) and add to PATH

```bash
bu şekilde yazarsak alan genişliyor
```

And the result should be as follows:
```bash
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:07 min
[INFO] Finished at: 2019-12-05T15:09:53+01:00
[INFO] ------------------------------------------------------------------------
```


## Project structure

#### Feature files

Gherkin feature files are located in the [resources/features](src/test/resources/features) directory.

#### Step classes

Cucumber steps definitions are located in [StepDefinitions](src/test/java/StepDefinitions) package.

#### Page Object Model

Pages and components definition can be found under [Pages](src/test/java/Pages) package.

#### Supported reporting

- XML: target/cucumber-report.xml
- JSON: target/cucumber-report.json
- cukes: target/cukes/index.html