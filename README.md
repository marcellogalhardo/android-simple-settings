# Simple Settings
SimpleSettings is a easy and fast configuration manager. It allow you to manager your APPs settings (like server url) and change it at runtime, to make effective manually tests.

For more details, see [this example][sample_file].

## Why created Simple Settings?
I work delivering android software to distant customers, sometime is more fast to simple change the server endpoint in the APP and not do a full build. For that, I have create this simple library to help my clientes and my team to change the configs on a already builded APP. Besides that, the configuration screen of Simple Settings allow the user to see the devices settings and easily export it to an e-mail or messaging (text). For more information on the settings screen, see the [images][images_folder].

## Download
**Step 1.** Add it in your root *build.gradle* at the end of repositories:
```gradle
allprojects {
	repositories {
		maven { url "https://jitpack.io" }
	}
}
```
**Step 2.** Add the dependency
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
If you think you can improve it do not be shy to make your Fork / Pull Request. I will love analyzing improvements to this code.

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

[images_folder][https://github.com/marcellogalhardo/SimpleSettings/tree/master/images]
[sample_file][https://github.com/marcellogalhardo/SimpleSettings/blob/master/sample/src/main/java/br/com/marcellogalhardo/sample/MainActivity.java]
