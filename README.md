# JetpackForms
[![Build](https://github.com/BenMMcLean/JetpackForms/actions/workflows/build.yml/badge.svg)](https://github.com/BenMMcLean/JetpackForms/actions/workflows/build.yml)

A Jetpack first forms library.

JetpackForms compartmentalizes data management and validation logic out of ViewModels and into
reusable field and validation objects.

## Setup
JetpackForms automatically publishes to Github Packages. To use the core library in your project, 
add the registry to your settings.gradle file:
```groovy
pluginManagement {
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/BenMMcLean/JetpackForms")
        }
    }
}
```
then add your dependency to your app level build.gradle file:
```groovy
dependencies {
    implementation 'cl.benm.forms:forms:LATEST_VERSION'
}
```

## Usage
To use the forms library, create a new form with any of the fields:
```kotlin
val form = Form.of(listOf(
    TextFormField(
        "name",
        listOf(RequiredValidator()),
        TextFormFactor.TEXT
    ),
    TextFormField.phone("phone", true) // Some fields have shortcut constructors for common data types
))
```
fields can then be accessed with:
```kotlin
form.getField<String>("name")
```

Out of the box, JetpackForms can also extract data from form fields into a map or flat Kotlin object:
```kotlin
val contentAsAMap = form.extract(MapFormExtractor())
val contentAsAPoko = form.extract(PokoFormExtractor(
    target = NameAndPhone::class
))
```

## Future
In the future, a compose library is planned that would provide a simple and automatic interface
for rendering form fields is planned. In addition, support for file selectors is planned.
