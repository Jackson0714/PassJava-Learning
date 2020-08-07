# 【从零开始用Swift开发一个iOS应用(仿微博)】开篇-1. demo上手体验

> 最近在学iOS开发，本系列会针对iOS从前到后的开发进行全面讲解，小到开发工具使用，大到应用市场上线。
![本篇思维导图](http://cdn.jayh.club/blog/20200721/71TWchflGEFs.png?imageslim)



**需求：**

``` json
1.显示一个橘黄色矩形
2.矩形上面一个按钮可以点击，并有响应事件
3.界面中心显示一张图片
```
**系统版本：**

```
Mac OS 版本：10.15.5
Xcode版本：11.5
```



# 一、创建demo项目

## 1.1 选择创建一个Xcode Project

![mark](http://cdn.jayh.club/blog/20200721/aDPmc8F2084r.png?imageslim)

## 1.2 选择Single View App
![mark](http://cdn.jayh.club/blog/20200721/eb6RAsjhot0X.png?imageslim)

# 二、代码实现
## 2.1 程序入口说明
Application/AppDelegate.swift文件中的@UIApplication注解，表示这个Class类是程序的入口
![mark](http://cdn.jayh.club/blog/20200721/2Oey6akOG2LK.png?imageslim)

## 2.2 代码结构说明
所有方法放到一个{}中，并有缩进。

和Java编码格式非常相似。

## 2.3 功能实现

### 2.3.1 创建一个视图，添加一个黄色矩形

``` swift
import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // 1.创建一个视图
        let v = UIView(frame: CGRect(x:0, y:0, width: 100, height: 100))
        
        // 2.设置背景颜色
        v.backgroundColor = UIColor.yellow
        
        // 3.添加到当前视图
        view.addSubview(v)
    }
}

```
效果如下所示：一个黄色矩形在左上角

![效果图](http://cdn.jayh.club/blog/20200721/5WzNRAphYhOY.png?imageslim)

### 2.3.2 添加一个按钮，并添加按钮点击事件的监听方法

``` swift
// 2.创建一个按钮
let btn = UIButton(type: .contactAdd)

// 2.1 添加到当前视图
v.addSubview(btn)

// 2.2 添加点击事件
btn.addTarget(self, action: #selector(btnClick), for: .touchUpInside)

// 2.3 btnClick事件方法输出日志
```

效果如下所示，一个按钮在左上角，点击按钮将会输出日志

![效果图](http://cdn.jayh.club/blog/20200721/1CFma3PflxKU.png?imageslim)

### 2.3.3 添加一个图片

``` swift
// 3.1 添加一个图片
let iv = UIImageView(image: #imageLiteral(resourceName: "2.jpeg"))

// 3.2 添加到视图
iv.center = view.center
```
图片的资源路径可以通过代码添加，也可以通过工具添加
![工具添加资源路径](http://cdn.jayh.club/blog/20200721/sg1uTF0QerVm.png?imageslim)

效果如下所示，图片会显示在屏幕中间。
![效果图](http://cdn.jayh.club/blog/20200721/1U8qQ48uN0I7.png?imageslim)


# 三、上述示例swift与object-c的语法对比

## 3.1 创建视图类比
``` swift
- Swift: UIView(XXX:)
- OC: [[UIView alloc] initWithXXX:]
  类名() == alloc / init 等价
```

## 3.2 类方法类比
``` swift
Swift: UIColor.yellow
OC: [UIColor yellow]
```

## 3.3 访问当前对象的属性类比

- 建议：都不使用`self.`。当编译器提示的时候，再添加，会对语境有更好的机会；

- 原因：闭包(类似于 OC block)需要使用self。

## 3.4 不需要`;`

除非多行代码语句写在同一行中。

## 3.5 枚举类型 type对比

``` swift
Swift：`type: .contactAdd`
OC: UIButtonType.ContactAdd
```

## 3.6 监听方法对比
    Swift: #selector，如果带参数，不需要使用`:`
    OC: @selector
## 3.7 调试对比
- Swift: print(xxx) 效率高，log中不包含时间，用#function来打印当前执行的方法
- OC: NSLog，用__FUNCTION__ 来打印当前执行的方法

# 四、注释的妙用

当我们想标注某段代码是需要refine的，我们可以添加注释标签：`TODO`。

如下图所示，我在注释中添加了`MARK`、`TODO`、`FIXME`标签前缀，这些特殊标记的锚点菜单将会显示在导航栏上，点击菜单即可跳转到对应注释的地方，非常方便。

![注释标签](http://cdn.jayh.club/blog/2020-07-21-081221.png?imageView2/0/interlace/1/q/75|watermark/2/text/5oKf56m66IGK5p625p6E/font/5qW35L2T/fontsize/720/fill/I0Y3MjExNA==/dissolve/70/gravity/SouthEast/dx/20/dy/10)