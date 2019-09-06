# OnlyToolbarView


  步骤1：添加jitpack库到你的根build.gradle

        allprojects {
            repositories {
                ...
                maven { url "https://jitpack.io" }
            }
        }

  步骤2：app的build.gradle添加依赖关系
 
        dependencies {
            implementation 'com.github.DizzyYang:OnlyToolbarView:1.8.0'
        }
