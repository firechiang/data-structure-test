#### 一、[& | ^ ~ << >>等位运算符简要说明][1]
#### 二、树型结构深度优先遍历算法
![object](https://github.com/firechiang/data-structure-test/blob/master/image/depth-first-tree.svg)
#### 三、基本算法一般具有五个特征
```bash
1，输入：一个算法应以待解决的问题的信息作为输入
2，输出：输入对应指令集处理后得到的信息
3，可行性：算法是可行的，即算法中的每一条指令都是可以实现的，均能在有限的时间内完成
4，有穷性：算法执行的指令个数是有限的，每个指令又在有限的时间内完成，因此算法也在有限的时间内完成
5，确定性：算法对特定合法的输入，其对应的输出是唯一的，即当算法从一个特定的输入开始，多次执行同意指令集结果总是相同的
```
#### 四、评价算法的优劣（时间复杂度和空间复杂度）
执行所需时间，取时间短的；执行所需内存空间，取较小的。


#### 五、Spring Crontab（定时任务，执行表达式说明） 
```bash
秒（0-59）     分钟（0-59）    小时（0-23）    日期（1-31）    月份（1-12）    星期（0-6）    年份（可选，就是可以不填）  
 *               *              *               *              *              *             *
---------------------------------------------------------------------------------------------------
*（代表所有可能的值）
,（多个值用逗号隔开。比如在月份那个位置上写上 1,6 就是每年的1月和6月执行）   
-（定义范围。比如在月份那个位置上写上 1-6 就是每年的1到6月执行）
/（执行间隔时间。比如在分钟那个位置上写上 */6 就是每隔6分钟执行一次）
L（注意：只能在日期列和星期列使用，表示每个月的最后一天或每个月的最后一个星期）
W（表示最近的工作日）
#（注意：只能在星期列使用，表示这个月的第几周）
---------------------------------------------------------------------------------------------------
0 0 0 * * *           # 每天凌晨12点执行
0 0 16 * * 5          # 每周五下午4点执行
0 30 9 11 11 *        # 每年11月11号上午9点30执行
0 15 10 L * *         # 每个月的最后一天10点15分执行
0 0 8 * 5 0#2         # 每年5月份第2周的星期天上午8点执行
0 0 12 15W * *        # 每个月离15号最近的工作日上午12点执行
```

[1]: https://github.com/firechiang/data-structure-test/tree/master/docs/bit-operation-desc.md
