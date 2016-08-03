# Simple Settings
SimpleSettings is an easy and fast configuration manager. It allows you to manage your APP settings (like your server url) and change it at runtime, allowing effective manual tests.

For more details, see [this example](https://github.com/marcellogalhardo/SimpleSettings/tree/master/images).

## Why have I created Simple Settings?
I work delivering android software to distant customers. Sometimes it is faster an easier to simply change the server URL in the APP without needing a rebuild. For that reason, I have created this simple library to help my clients and my team to change settings on an APP that has already been built. Besides that, the configuration screen of Simple Settings allows the user to see the device settings and easily export it through e-mail or text messaging. For more information on the configuration screen, see the [images](https://github.com/marcellogalhardo/SimpleSettings/blob/master/sample/src/main/java/br/com/marcellogalhardo/sample/MainActivity.java).

## Download
**Step 1.** Add the maven repository in your project level *build.gradle* file (place it at the end of your repository list):
```gradle
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```
**Step 2.** Add the dependency in your app level *build.gradle* file:
```gradle
dependencies {
	compile 'com.github.marcellogalhardo:SimpleSettings:0.1.2'
}
```
That's it!

## Using

### Simple Usage

#### Set APP Default Settings
```java
SimpleSettings settings = new SimpleSettings.Builder()
  .baseUrl("www.google.com.br")
  .timeout(20)
  .build();
SimpleSettingsHelper.putDefaultSettings(MainActivity.this, settings);
```

#### Start Simple Settings Activity
```java
if (BuildConfig.DEBUG) {
  SimpleSettingsHelper.startSettingsActivity(MainActivity.this);
}
```

#### Get Settings
```java
SimpleSettings settings = SimpleSettingsHelper.getSimpleSettings(context);
String baseUrl = settings.getBaseUrl();
int timeout = settings.getTimeout();
```

# Contributors
If you think you can help us improve this lib do not be affraid of Pull Requesting. I will love analyzing and discussing improvements for this lib.

## Pictures
![Settings-Http](https://github.com/marcellogalhardo/SimpleSettings/blob/master/images/settings-http.png)
![Settings-General](https://github.com/marcellogalhardo/SimpleSettings/blob/master/images/settings-general.png)
![Settings-Screen](https://github.com/marcellogalhardo/SimpleSettings/blob/master/images/settings-screen.png)
![Settings-Options](https://github.com/marcellogalhardo/SimpleSettings/blob/master/images/settings-options.png)
![Settings-Options-Copy](https://github.com/marcellogalhardo/SimpleSettings/blob/master/images/settings-options-copy.png)
![Settings-Options-Share](https://github.com/marcellogalhardo/SimpleSettings/blob/master/images/settings-options-share.png)

## License
Copyright 2016 Marcello Galhardo

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at: [here](http://www.apache.org/licenses/LICENSE-2.0).

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
