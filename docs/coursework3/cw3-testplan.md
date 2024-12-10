# Test Plan (and eventually Test Report) - Example Template

#### Above
|Contents|
|--------|
|[Team Management](#team-management)|
|--------|
|[Test Plan](#test-plan)|
|[Plan Category](#plan-category)|
|[Plan Transaction](#plan-transaction)|
|[Plan App](#plan-app)|
|--------|
|[Test Report](#test-report)|
|[Report Category](#report-category)|
|[Report Transaction](#report-transaction)|
|[Report App](#report-app)|


## Team Management
&nbsp;&nbsp;&nbsp;&nbsp;4.15, Zhihang Zhu pushed the origin code to the master, other members pull it to start the project. 4.17, we organised the first group meeting and carefully read the ClassDescription, then we decided to finish BoCCategory and BoCTransaction first. Three of group members (Hongjia Xue, Ao Li, Zhiwen Chen) for BoCCategory and others (Zhiyu Dong, Zhihang Zhu,Zhiyu Dong) for BoCTransaction. During writing tests for BoCCategory and BoCTransaction, we divided these into two stages: **write tests** and **fix bugs that had been founded,by creating Milestones.**

&nbsp;&nbsp;&nbsp;&nbsp;So, our general strategy is to solve the BoCCategory and BoCTransaction within 3 people's group, and after that, all of our six people can solve BoCApp together

&nbsp;&nbsp;&nbsp;&nbsp;After finish BoCCategory and BoCTransaction in 4.22, we organised a meeting to divide work related to BoCApp.java. Firstly, six static methods in BoCApp are allocated to six group members to test and fix bugs. Also, this process contained creationsof new branches, milestones, issuses and labels to manage the projec and control the version. 

&nbsp;&nbsp;&nbsp;&nbsp;After finish these six static methods, we began to test and fix bugs in the **mian method**. During the whole process of testing and debuging, we recorded every test and bugs to the corresponding reports.

&nbsp;&nbsp;&nbsp;&nbsp;For the whole process of testing and debugging we created issues to represent detailed tests that should be written and bugs that should be fixed, labeld by different labels to mark off tests and bugs, then linked them to corresponding milestones and assigned to related members. Closed issues in time after solved them. We also used branches to make version control. master is the defaulted and protected stable version branch, develop is the newest version branch. And for every issue, we create a new branch to handle it. After finish the current issue, merged this branch to the develop to make sure that develop is always the newest version. 

&nbsp;&nbsp;&nbsp;&nbsp;When finished testing and debugging for the whole project, we orgnised a meeting to do the following things:1. Merge and finish the final report and plan markdown files; 2.  Merge all the branches to the develop and test project on the develop branch to ensure the the develop branch has the newest version that meet the requirements.3.Merge the develop to the master branch to generate the final version.

## Test Plan

### Plan Category
Author: Ao Li. Hongjia Xue
edit time: 4/17 16:21
#### Function 1 'DefaultConstructor':

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|1.1|null|"New Category","0.00","0.00"|

#### Function 2 'MainConstructors':

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|2.1|"AoLi"|"AoLi","0.00","0.00"|
|2.2|"ZhiwenChen"|"ZhiwenChen","0.00","0.00"|
|2.3|"I-must-not-input-too-much-characters-like-this-one"|(Throw exception)"Invalid Input."|

#### Function 3 'CategoryName':
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|3.1|"apple"|"apple"|
|3.2|"I-must-not-input-too-much-characters-like-this-one"|(Throw exception)"Invalid Input."|

#### Function 4 'CategoryBudget':
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|4.1|"test","50.00"|"50.00"|
|4.2|"test","-50.00"|(Throw exception)"Invalid Input."|
|4.3|"test","0.00"|(Throw exception)"Invalid Input."|

#### Function 5 'CategorySpend':
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|5.1|"test",add"50.00"|"50.00"|
|5.2|"test",add"50.00",add"50.00"|"100.00"|
|5.3|"test",add"50.00",remove"50.00"|"0.00"|
|5.4|"test",remove"50.00",remove"50.00"|(Throw exception)"Invalid Input."|
|5.5|"test",add"50.00",add"0.00"|"50.00"|

#### Function 6 'SetCategoryName':
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|6.1|"test","apple"|"apple"|
|6.2|"test","I-must-not-input-too-much-characters-like-this-one"|(Throw exception)"Invalid Input.|
|6.3|"test","test"|"test"|
|6.4|"test",""|(Throw exception)"Invalid Input."|
|6.5|"test","\r"|(Throw exception)"Invalid Input."|

#### Function: 7 setCategoryBudget

|Test                   |Inputs |Expected Outcome|
|----|------|----------------|
|testSetCategoryBudget1 |50     |50              |
|testSetCategoryBudget2 |0      |invaild input   |
|testSetCategoryBudget3 |-50    |invaild input   |


#### Function: 8 addExpense

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testAddExpense1| 50| spend=50|
|testAddExpense2| -50| invaild input|
|testAddExpense3| 0| spend=0|


#### Function: 9 removeExpense

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testRemoveExpense1|first add50,then remove 50|spend=0|
|testRemoveExpense2|first add0,then remove 50|total spend can't less than 0|
|testRemoveExpense3|first add50,then remove -50|can't remove negative value|

#### Function: 10 resetBudegtSpend

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testResetBudgetSpend1|first add50,then reset|spend=0|
|testResetBudgetSpend2|first remove50,then reset|spend=0|
|testResetBudgetSpend3|first adde50,remove100,then reset|spend=0|

#### Function:11 getRemainingBudget

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testGetRemainingBudget1|add 50,remove 30|spend=20|
|testGetRemainingBudget2|add 50,remove 50|spend=0|
|testGetRemainingBudget3|add 30,remove 50|i think spend can't less than 0|

#### Function:12 toString

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testToString1|name="siri",budget=100,addexpense=50|Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)|Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)|
|testToString2|name="siri",budget=50,addexpense=100|Siri(￥50.00) - Est. ￥100.00 (￥50.00 Overspent)|Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)|
|testToString3|name=,budget=100,addexpense=50|New Category(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)|

### Plan Transaction:

|[----Go to Above----](#above)

Author: Zhiyu Dong, Qiwen Wang
#### Function:1 DefaultConstructor
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|nonparameters|null|null|

#### Function:2 MainConstructors
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|threeParameters|tName = "Bob", tValue = 123456, tCat = 20|"Bob", 123456, 20|
|threeParameters|tName = "Zhiyu Dong", tValue = 123456, tCat = 20|"Zhiyu Dong", 123456, 20|
|threeParameters|tName = "invalidNameWithOver25Characters", tValue = 123456, tCat = 20|"invalidNameWithOver25Characters", 123456, 20|
|threeParameters|tName = "Bob", tValue = 12.3456, tCat = 20|"Bob", 12.3456, 20|
|threeParameters|tName = "Bob", tValue = -12.3456, tCat = 20|"Bob", -12.3456, 20|
|threeParameters|tName = "Bob", tValue = 123456, tCat = -20|"Bob", 123456, -20|
|testInput|tName = "Bob", tValue = 123456, tCat = 20|True, True|
|testInput|tName = "Zhiyu Dong", tValue = 123456, tCat = 20|True, True|
|testInput|tName = "invalidNameWithOver25Character", tValue = 123456, tCat = 20|False, True|
|testInput|tName = "Bob", tValue = 12.3456, tCat = 20|True, True|
|testInput|tName = "Bob", tValue = -123456, tCat = 20|True, False|
|testInput|tName = "Bob", tValue = 123456, tCat = -20|True, True|

#### Function: 3 transactionName
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testTypeName|tName = "Bob", tValue = 123456, tCat = 20|True|

#### Function: 4 transactionValue
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testTypeValue|tName = "Bob", tValue = 123456, tCat = 20|True|

#### Function: 5 transactionCategory
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testTypeCat|tName = "Bob", tValue = 123456, tCat = 20|True| 

#### Function:6 transactionTime

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testTransactionTime | void| new Date()|


#### Function:7 setTransactionName

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|setTransactionNameTest|abcdefghijklmnopqrstuvwxyz|abcdefghijklmnopqrstuvwxy|
|setTransactionNameTest|Paul George |abcdefghijklmnopqrstuvwxy |

#### Function:8 setTransactionValue

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|setTransactionValueTest| new BigDecimal("-66.66")|null|
|setTransactionValueTest| new BigDecimal("12345")|new BigDecimal("12345")|
|setTransactionValueTest| 	new BigDecimal("6789")|new BigDecimal("12345")|

#### Function:9 setTransactionCategory

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|setTransactionCategoryTest|1|1|
|setTransactionCategoryTest|0|0|
|setTransactionCategoryTest|20|20|
|setTransactionCategoryTest|-5|20|

### Plan App:

|[----Go to Above----](#above)

Author: Zhiwen Chen, Zhihang Zhu
#### Function:1 Main

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testmain1|"Z"|command not recognized|
|testmain2|"4"|the category number does not exit|

#### Function:2 CategoryOverview
|Test|Inputs|Expected Outcome|
|----|------|----------------|
|test1|BoCApp.UserCategories.add(new BoCCategory("Unknown"));BoCCategory BillsCategory = new BoCCategory("Bills");BillsCategory.setCategoryBudget(new BigDecimal("120.00"));BoCApp.UserCategories.add(BillsCategory)BoCCategory Groceries = new BoCCategory("Groceries");Groceries.setCategoryBudget(new BigDecimal("75.00"));BoCApp.UserCategories.add(Groceries);BoCCategory SocialSpending = new BoCCategory("Social");SocialSpending.setCategoryBudget(new BigDecimal("100.00"));BoCApp.UserCategories.add(SocialSpending);|1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)1) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)2) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)3) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)|
|test2|null|(Throw exception)"No category include.\n"|

#### Function:3 ListTransactionsForCategory

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|testListTransactionsForCategory1|3|3) (Tue Apr 27 15:21:34 CST 2021) RockCity Drinks - ¥8.50</br>3) (Tue Apr 27 15:21:34 CST 2021) The Mooch - ¥13.99 |
|testListTransactionsForCategory2|0|0) (Tue Apr 27 15:25:33 CST 2021) Rent - ¥850.00|

#### Function:4 AddTransaction

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|test1|\nFirst_test\n100.00\n1\n|First_test(￥100.00) was added to Bills|
|test2|\n\n100.00\n1\n|null|
|test3|\nczw\n\n1\n|null|

#### Function:4 ChangeTransactionCategory

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|1|(System.in) 2, 2|0) Unknown($0.00) - Est. $850.00 ($850.00 Overspent)1) Bills($120.00) - Est. $75.00 ($45.00 Remaining)2) Groceries($75.00) - Est. $68.99 ($6.01 Remaining)3) Social($100.00) - Est. $22.49 ($77.51 Remaining)|
|2|(System.in) 2), 2, 2|Invaild input, please enter again:|
|3|(System.in) \n, 2, 2|Invaild input, please enter again:|
|4|(System.in) 10, 2, 2|Can't find the category, please enter again:|
|5|(System.in) 2, 5, 2|"The category number does not exist, please enter again:"|
|6|(System.in) abs, 2, 2|Invaild input, please enter again:|

#### Function:6 AddCategory

|Test|Inputs|Expected Outcome|
|----|------|----------------|
|test1|\nFirst_test\n100.00\n|First_test",new BigDecimal("100.00")|
|test2|\n\n100.00\n|New Category",new BigDecimal("100.00")|
|test3|\nthis_is_a_reallyyyyyyyyyyy_long_test\n123.45\n|invaild input!|

|[----Go to Above----](#above)|

## Test Report
Author: Ao Li, Hongjia Xue
### Report Category
<table border = "1">
    <thead>
        <caption>test for BoCCategory      </caption>
        <tr>
            <th>No.</th>
            <th>Target methods</th>
            <th>Test Name</th>
            <th>Input</th>
            <th>Output</th>
            <th>Expected</th>
            <th>Status</th>
            <th>Time</th>
            <th>Importance</th>
        </tr>
    </thead>
    <tr>
        <td>1.1</td>
        <td>BoCCategory</td>
        <td>DefaultConstructor</td>
        <td>null</td>
        <td>CategoryName()=="New Category",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td>CategoryName()=="New Category",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.23</td>
        <td>★</td>
    </tr>
    <tr>
        <td>2.1</td>
        <td rowspan = "3">BoCCategory</td>
        <td>TestMainConstructors1</td>
        <td>"AoLi"</td>
        <td>CategoryName()=="AoLi",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td>CategoryName()=="AoLi",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.25</td>
        <td>★</td>
    </tr>
    <tr>
        <td>2.2</td>
        <td>TestMainConstructors2</td>
        <td>"ZhiwenChen"</td>
        <td>CategoryName()=="ZhiwenChen",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td>CategoryName()=="ZhiwenChen",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.25</td>
        <td>★</td>
    </tr>
    <tr>
        <td>2.3</td>
        <td>TestMainConstructors3</td>
        <td>"I-must-not-input-too-much-characters-like-this-one"</td>
        <td>CategoryName()==""I-must-not-input-too-much-characters-like-this-one"",<br>CategoryBudget()==0.00,<br>CategorySpend()==0.00</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="#FF0000">fail</font> </td>
        <td>4.21 16.26</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>3.1</td>
        <td rowspan = "2">CategoryName</td>
        <td>TestCategoryName1</td>
        <td>"apple"</td>
        <td>CategoryName() == "apple"</td>
        <td>CategoryName() == "apple"</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.26</td>
        <td>★</td>
    </tr>
    <tr>
        <td>3.2</td>
        <td>TestCategoryName2</td>
        <td>"I-must-not-input-too-much-characters-like-this-one"</td>
        <td>CategoryName() == "I-must-not-input-too-much-characters-like-this-one"</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="#FF0000">fail</font> </td>
        <td>4.21 16.26</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>4.1</td>
        <td rowspan = "4">CategoryBudget</td>
        <td>testCategoryBudget1</td>
        <td>"50.00"</td>
        <td>CategoryBudget() == "50.00"</td>
        <td>CategoryBudget() == "50.00"</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.27</td>
        <td>★</td>
    </tr>
    <tr>
        <td>4.2</td>
        <td>testCategoryBudget2</td>
        <td>"-50.00"</td>
        <td>CategoryBudget() == "-50.00"</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.28</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>4.3</td>
        <td>testCategoryBudget3</td>
        <td>"0.00"</td>
        <td>CategoryBudget() == "0.00"
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="#FF0000">fail</font> </td>
        <td>4.21 16.28</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>4.4</td>
        <td>testCategoryBudget4</td>
        <td>"not_a_float"</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.29</td>
        <td>★</td>
    </tr>
    <tr>
        <td>5.1</td>
        <td rowspan = "5">CategorySpend</td>
        <td>testCategorySpend1</td>
        <td>addExpense("50.00")</td>
        <td>CategorySpend() == "50.00"</td>
        <td>CategorySpend() == "50.00"</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.30</td>
        <td>★</td>
    </tr>
    <tr>
        <td>5.2</td>
        <td>testCategorySpend2</td>
        <td>addExpense("50.00")<br>addExpense("50.00")</td>
        <td>CategorySpend() == "100.00"</td>
        <td>CategorySpend() == "100.00"</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.30</td>
        <td>★</td>
    </tr>
    <tr>
        <td>5.3</td>
        <td>testCategorySpend3</td>
        <td>addExpense("50.00")<br>removeExpense("50.00")</td>
        <td>CategorySpend() == "0.00"</td>
        <td>CategorySpend() == "0.00"</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.30</td>
        <td>★</td>
    </tr>
    <tr>
        <td>5.4</td>
        <td>testCategorySpend4</td>
        <td>removeExpense("50.00")<br>removeExpense("50.00")</td>
        <td>CategorySpend() == "-100.00"</td>
        <td>CategorySpend() == "-100.00"</td>
        <td><font color="FF0000">fail</font></td>
        <td>4.21 16.30</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>5.5</td>
        <td>testCategorySpend5</td>
        <td>addExpense("50.00")<br>addExpense("0.00")</td>
        <td>CategorySpend() == "50.00"</td>
        <td>CategorySpend() == "50.00"</td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.31</td>
        <td>★</td>
    </tr>
    <tr>
        <td>6.1</td>
        <td rowspan = "5">SetCategoryName</td>
        <td>testSetCategoryName1</td>
        <td>new BoCCategory("test"),<br>setCategoryName("Apple")</td>
        <td>CategoryName() == "apple" </td>
        <td>CategoryName() == "apple" </td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.31</td>
        <td>★</td>
    </tr>
        <td>6.2</td>
        <td>testSetCategoryName2</td>
        <td>new BoCCategory("test"),<br>setCategoryName("I-must-not-input-too-much-characters-like-this-one")</td>
        <td>CategoryName() == "I-must-not-input-too-much-characters-like-this-one"</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="#FF0000">fail</font> </td>
        <td>4.21 16.32</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>6.3</td>
        <td>testSetCategoryName3</td>
        <td>new BoCCategory("test"),<br>setCategoryName("test")</td>
        <td>CategoryName() == "test" </td>
        <td>CategoryName() == "test" </td>
        <td><font color="00FF00">pass</font></td>
        <td>4.21 16.32</td>
        <td>★</td>
    </tr>
    <tr>
        <td>6.4</td>
        <td>testSetCategoryName4</td>
        <td>new BoCCategory("test"),<br>setCategoryName("")</td>
        <td>CategoryName()==""</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="#FF0000">fail</font> </td>
        <td>4.21 16.33</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>6.5</td>
        <td>testSetCategoryName5</td>
        <td>new BoCCategory("test"),<br>setCategoryName("\r")</td>
        <td>CategoryName()=="\r"</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td><font color="#FF0000">fail</font> </td>
        <td>4.21 16.34</td>
        <td>★★★</td>
    </tr>
    </thead>
    <tr>
        <td>7.1</td>
        <td rowspan = "3">setCategoryBudget</td>
        <td>testSetCategoryBudget1</td>
        <td>BigDecimal("50.00")</td>
        <td>BigDecimal("50.00")</td>
        <td>BigDecimal("50.00")</td>
        <td>pass</td>
        <td>4.21 16.34</td>
        <td>★</td>
    </tr>
    <tr>
        <td>7.2</td>
        <td>testSetCategoryBudget2</td>
        <td>BigDecimal("-50.00")</td>
        <td>BigDecimal("-50.00")</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td>fail</td>
        <td>4.21 16.34</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>7.3</td>
        <td>testSetCategoryBudget3</td>
        <td>BigDecimal("0.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td>fail</td>
        <td>4.21 16.34</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>8.1</td>
        <td rowspan = "3">addExpense</td>
        <td>testAddExpense1 </td>
        <td>BigDecimal("50.00")</td>
        <td>BigDecimal("50.00")</td>
        <td>BigDecimal("50.00")</td>
        <td>pass</td>
        <td>4.21 16.34</td>
        <td>★</td>
    </tr>
    <tr>
        <td>8.2</td>
        <td>testAddExpense2</td>
        <td>BigDecimal("50.00"),<br>BigDecimal("50.00")</td>
        <td>BigDecimal("100.00")</td>
        <td>BigDecimal("100.00")</td>
        <td>pass</td>
        <td>4.21 16.35</td>
        <td>★</td>
    </tr>
    <tr>
        <td>8.3</td>
        <td>testAddExpense3</td>
        <td>BigDecimal("-50.00")</td>
        <td>BigDecimal("-50.00")</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td>fail</td>
        <td>4.21 16.35</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>9.1</td>
        <td rowspan = "3">removeExpense </td>
        <td>testRemoveExpense1</td>
        <td>addExpense(new BigDecimal("50.00"),<br>removeExpense(new BigDecimal("50.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>pass</td>
        <td>4.21 16.35</td>
        <td>★</td>
    </tr>
    <tr>
        <td>9.2</td>
        <td>testRemoveExpense2</td>
        <td>addExpense(new BigDecimal("50.00"),<br>  removeExpense(new BigDecimal("-50.00")</td>
        <td>BigDecimal("100.00")</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td>fail</td>
        <td>4.21 16.36</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>9.3</td>
        <td>testRemoveExpense3</td>
        <td>addExpense(new BigDecimal("0.00"),<br>     removeExpense(new BigDecimal("50.00")</td>
        <td>BigDecimal("-50.00")</td>
        <td>(Throw exception)"Invalid Input."</td>
        <td>fail</td>
        <td>4.21 16.36</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>10.1</td>
        <td rowspan = "3">resetBudegtSpend</td>
        <td>testResetBudgetSpend1</td>
        <td>addExpense(new BigDecimal("50.00"))</td>
        <td>BigDecimal("0.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>pass</td>
        <td>4.21 16.37</td>
        <td>★</td>
    </tr>
    <tr>
        <td>10.2</td>
        <td>testResetBudgetSpend2</td>
        <td>removeExpense(new BigDecimal("50.00"))</td>
        <td>BigDecimal("0.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>pass</td>
        <td>4.21 16.37</td>
        <td>★</td>
    </tr>
    <tr>
        <td>10.3</td>
        <td>testResetBudgetSpend3</td>
        <td>setCategoryBudget(new BigDecimal("50.00")),<br>removeExpense(new BigDecimal("30.00"))</td>
        <td>BigDecimal("0.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>pass</td>
        <td>4.21 16.37</td>
        <td>★</td>
    </tr>
    <tr>
        <td>11.1</td>
        <td rowspan = "3">getRemainingBudget</td>
        <td>testGetRemainingBudget1</td>
        <td>setCategoryBudget(new BigDecimal("50.00")),<br>addExpense(new BigDecimal("30.00"))</td>
        <td>BigDecimal("20.00")</td>
        <td>BigDecimal("20.00")</td>
        <td>pass</td>
        <td>4.21 16.38</td>
        <td>★</td>
    </tr>
    <tr>
        <td>11.2</td>
        <td>testGetRemainingBudget2</td>
        <td>setCategoryBudget(new BigDecimal("50.00")),<br>addExpense(new BigDecimal("50.00"))</td>
        <td>BigDecimal("0.00")</td>
        <td>BigDecimal("0.00")</td>
        <td>pass</td>
        <td>4.21 16.38</td>
        <td>★</td>
    </tr>
    <tr>
        <td>11.3</td>
        <td>testGetRemainingBudget3</td>
        <td>setCategoryBudget(new BigDecimal("30.00")),<br>addExpense(new BigDecimal("50.00"))</td>
        <td>BigDecimal("-20.00")</td>
        <td>BigDecimal("-20.00")</td>
        <td>pass</td>
        <td>4.21 16.38</td>
        <td>★</td>
    </tr>
        <td>12.1</td>
        <td rowspan = "4">toString</td>
        <td>testToString1</td>
        <td>setCategoryName("Siri"),<br>setCategoryBudget(new BigDecimal("100.00"))<br>addExpense(new BigDecimal("50.00"))</td>
        <td>Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)|Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)</td>
        <td>Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)|Siri(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)</td>
        <td>pass</td>
        <td>4.21 16.38</td>
        <td>★</td>
    </tr>
    <tr>
        <td>12.2</td>
        <td>testToString2</td>
        <td>setCategoryName("Siri"),<br>setCategoryBudget(new BigDecimal("100.00")),<br>addExpense(new BigDecimal("100.00"))</td>
        <td>Siri(￥100.00) - Est. ￥100.00 (￥0.00 Remaining)|Siri(￥100.00) - Est. ￥100.00 (￥0.00 Remaining)</td>
        <td>Siri(￥100.00) - Est. ￥100.00 (￥0.00 Remaining)|Siri(￥100.00) - Est. ￥100.00 (￥0.00 Remaining)</td>
        <td>pass</td>
        <td>4.21 16.38</td>
        <td>★</td>
    </tr>
    <tr>
        <td>12.3</td>
        <td>testToString3</td>
        <td>setCategoryName(""),<br>setCategoryBudget(new BigDecimal("100.00")),<br>addExpense(new BigDecimal("50.00"))</td>
        <td>(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)</td>
        <td>New Category(￥100.00) - Est. ￥50.00 (￥50.00 Remaining)</td>
        <td>fail</td>
        <td>4.21 16.39</td>
        <td>★★★★</td>
    </tr>
    <tr>
        <td>12.4</td>
        <td>testToString5</td>
        <td>setCategoryName("Siri"),<br>ssetCategoryBudget(new BigDecimal("50.00")),<br>addExpense(new BigDecimal("100.00"))</td>
        <td>Siri(￥50.00) - Est. ￥100.00 (￥-50.00 Remaining)</td>
        <td>Siri(￥50.00) - Est. ￥100.00 (￥50.00 Overspent)</td>
        <td>fail</td>
        <td>4.21 16.39</td>
        <td>★★★★</td>
    </tr>
</table>
<br>

|[----Go to Above----](#above)|

<h4>Logs for bugs</h4>

> **1.** Bugs in method **BoCCategory_DefaultConstructor**. There have one bug in test No.2 
> 
> **edit in 4/25 14.21**
> **★★★**
> 1. Class **BoCCtagegory** constructor should only apply string which length need to be limited to 15. However, the origin code do not check the input.<br>
>
> ***origin code:***
> ```
> public BoCCategory(String newTitle) {
>		CategoryName = newTitle;
>		CategoryBudget = new BigDecimal("0.00");
>		CategorySpend = new BigDecimal("0.00");
>	}
>```
>***Fixed code:***
>```
>public BoCCategory(String newTitle) {
>		if(newTitle.length()>15)
>		{
>			System.err.println("Invalid Input! Title must less than 15 characters!\n");
>		}
>		else 
>		{
>			CategoryName = newTitle;
>			CategoryBudget = new BigDecimal("0.00");
>			CategorySpend = new BigDecimal("0.00");
>		}
>	}
>```

> **2.** Bugs in method **CategoryBudget** and **setCategoryBudget** There have two bugs in test No.4 and No.7 
> 
> **edit in 4/26 15.09**
> **★★**
> 1. Changeable budget for the category, which should be gearter than zero.
so the function 'setCategoryBudget' must receive a BigDecimal number which is larger than 0; But the funtion here exits an failure which can receive a BigDecimal("0.00") rather than report an error input.
> 2. When in **CategoryBudget** there have no situation that budget can be or greater than zero if **setCategoryBudget** have been fixed.<br>
>
>***origin code:***
>```
>public String CategoryName() {
>		return CategoryName;
>	}
>
>public void setCategoryBudget(BigDecimal newValue) {
>		// 1 means bigger, -1 means smaller, 0 means same
>			CategoryBudget = newValue;
>		}
>	}
>```
>***Fixed code***
>```
>public String CategoryName() {
>		return CategoryName;
>	}
>
>public void setCategoryBudget(BigDecimal newValue) {
>		// 1 means bigger, -1 means smaller, 0 means same
>		if (newValue.compareTo(new BigDecimal("0.00")) == 1) {
>			CategoryBudget = newValue;
>		}
>		else if(newValue.compareTo(new BigDecimal("0.00")) == 0) {
>			CategoryBudget = new BigDecimal("-9999.99"); 
>         //if an invaild  input was received, the Budget will be set as "-9999.99"
>			System.err.println("CategoryBudget can't be zero!");
>		}
>		else {
>			CategoryBudget = new BigDecimal("-9999.99");
>			System.err.println("CategoryBudget can't be negative!");
>		}
>``` 

> **3.** Bugs in method **SetCategoryName** have three bugs in test No.6 
> 
> **edit in 4/26 17.51**
> **★★★**
> 1. Category Name (String) – changeable category name, at most 15 characters, so when set CategoryName is still need to follow the rules
> 2. The name can not be only a '\r' or have 0 characters.
> 3. When input invaild string there have no error message and warning and just set name in the invaild format.<br>
>
>***origin code:***
>```
> public void setCategoryName(String newName) {
>		CategoryName = newName;
>	}
>```
>***Fixed code:***
>```
>public void setCategoryName(String newName) {
>		if (newName.length()>15||newName=="\r"||newName.length()==0) {
>			CategoryName = "wrongInput";
>			System.err.println("Invalid Input.You need to Input a right string no more than 15 characters\n");
>		}
>		else {
>			CategoryName = newName;}
>	}
>```

> **4.** Bug in method **addExpense** have one bug in test N0.8 
> 
> **edit in 4/26 19.03**
> **★★**
> 1. This function should take a BigDecimal and ad it to the current toal spend for the 
category
> 2. Expense can not be less than zero but in origin method this can output negative number if the input is negative number
>
> **origin code:**
>```
>public void addExpense(BigDecimal valueToAdd) {
>		CategorySpend = CategorySpend.add(valueToAdd);
>	}
>```
> **Fixed code:**
>```
>public void addExpense(BigDecimal valueToAdd) {
>		int i=valueToAdd.compareTo(BigDecimal.ZERO);
>			if (i==-1) {
>				System.err.println("invaild input! addExpense can not be negative!");
>			}
>			else {
>				CategorySpend = CategorySpend.add(valueToAdd);
>				}
>	}
>```

> **5.** Bug in method **removeExpense** have two bugs in test No.9
> 
> **edit in 4/26 20.08**
> **★★★**
> 1. This function sould take a BigDecimal and subtract it from the current total spend for the 
category<br>
> 2. de
>***origin code:***
>```
>public void removeExpense(BigDecimal valueToRemove) {
>		CategorySpend = CategorySpend.subtract(valueToRemove);
>	}
>```
>
>***Fixed code:***
>```
>public void removeExpense(BigDecimal valueToRemove) {
>		int i=valueToRemove.compareTo(BigDecimal.ZERO);
>		if (i==-1) {
>			System.err.println("invaild input! removeExpense can not be negative!");
>		}
>		else {
>			int j=(CategorySpend.subtract(valueToRemove)).compareTo(BigDecimal.ZERO);
>			if(j==-1){
>			System.err.println("invaild input! removeExpense can not be smaller than addExpense!");
>			}
>			else {
>				CategorySpend = CategorySpend.subtract(valueToRemove);
>				}
>		}
>	}
>```

> **6.** Bug in method **toString** there have two bugs in test No.12 
> 
> **edit in 4/26 21.01**
> **★★★★**
> 1. If this object is converted to a String, it should be printed out in the following format:
“[Category Name](Budget: ¥xx.xx) – ¥yy.yy” (¥zz.zz Remaining)”
or “¥zz.zz Overspent” if overspent rather than budget left.
> 2. In origin code if there have no string in CategoryName there have no name in output. What's more, When budget is less than spend the outout string is still "XX Remaining"<br>
> 
>***origin code:***
>```
>public String toString() {
>		return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
>				+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
>	}
>```
>
>***Fixed code:***
>```
>public String toString() {
>		BigDecimal a = new BigDecimal(0);
>		int com = getRemainingBudget().compareTo(a);
>		if (CategoryName == null){
>			CategoryName = "New Category";
>		}
>		if(com == -1){
>			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
>					+ " (¥" +  (getRemainingBudget().multiply(new BigDecimal(-1))).toPlainString() + " Overspent)";
>		}else{
>			return CategoryName + "(¥" + CategoryBudget.toPlainString() + ") - Est. ¥" + CategorySpend.toPlainString()
>				+ " (¥" + getRemainingBudget().toPlainString() + " Remaining)";
>		}
>	}
>```
|[----Go to Above----](#above)|

### Report Transaction
Author: Zhiyu Dong, Qiwen Wang

<h4>Test of Transaction</h4>
<table>
<tr>
 <th align = "center" > No. </th>
 <th align = "center" > Tests name </th>
 <th align = "center" > Target method </th>
 <th align = "center" > Input </th>
 <th align = "center" > Output </th>
 <th align = "center" > Expected </th>
 <th align = "center" > status </th>
 <th align = "center" > time </th>
 <th align = "center" > importance </th>
 <th align = "center" > Test Author </th>
</tr>

<tr>
<td align = "center" > 1.1 </td>
<td rowspan = "2" align = "center" > nonparameters </td>
<td rowspan = "2" align = "center" > BoCTransaction() </td>
<td align = "center" > null </td>
<td align = "center" > null </td>
<td align = "center" > null </td>
<td align = "center" > <font color = "00FF00">pass</font> </td>
<td align = "center" > 4.21 22:41 </td>
<td align = "center" > ★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" >1.2 </td>
<td align = "center" > null </td>
<td align = "center" > bocTransactionTest@185a6e9 </td>
<td align = "center" > [Pending Transaction] </td>
<td align = "center" ><font color = "FF0000"> fail </font></td>
<td align = "center" > 4.21 22:44 </td>
<td align = "center" > ★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 2.1 </td>
<td rowspan = "6" align = "center" > threeParameters </td>
<td rowspan = "6" align = "center" > BoCTransaction(String tName, BigDecimal tValue, int tCat) </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = 20 </td>
<td align = "center" > "Bob", 123456, 20 </td>
<td align = "center" > "Bob", 123456, 20 </td>
<td rowspan = "6" align = "center" ><font color = "00FF00">pass</font></td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 2.2 </td>
<td align = "center" > tName = "Zhiyu Dong", tValue = 123456, tCat = 20 </td>
<td align = "center" > "Zhiyu Dong", 123456, 20 </td>
<td align = "center" > "Zhiyu Dong", 123456, 20 </td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 2.3 </td>
<td align = "center" > tName = "invalidNameWithOver25Characters", tValue = 123456, tCat = 20 </td>
<td align = "center" > "invalidNameWithOver25Characters", 123456, 20 </td>
<td align = "center" > "invalidNameWithOver25Characters", 123456, 20 </td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 2.4 </td>
<td align = "center" > tName = "Bob", tValue = 12.3456, tCat = 20 </td>
<td align = "center" > "Bob", 12.3456, 20 </td>
<td align = "center" > "Bob", 12.3456, 20 </td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 2.5 </td>
<td align = "center" > tName = "Bob", tValue = -12.3456, tCat = 20 </td>
<td align = "center" > "Bob", -12.3456, 20 </td>
<td align = "center" > "Bob", -12.3456, 20 </td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" >2.6 </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = -20 </td>
<td align = "center" > "Bob", 123456, -20 </td>
<td align = "center" > "Bob", 123456, -20 </td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 3.1</td>
<td rowspan = 6 align = "center" > testInput </td>
<td rowspan = 6 align = "center" > BoCTransaction </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = 20 </td>
<td align = "center" > True, True </td>
<td align = "center" > True, True </td>
<td align = "center" ><font color = "00FF00"> pass </font></td>
<td align = "center" >4.21 18:30 </td>
<td align = "center" > ★★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 3.2 </td>
<td align = "center" > tName = "Zhiyu Dong", tValue = 123456, tCat = 20 </td>
<td align = "center" > True, True </td>
<td align = "center" > True, True </td>
<td align = "center" ><font color = "00FF00"> pass </font></td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" >3.3 </td>
<td align = "center" > tName = "invalidNameWithOver25Characters", tValue = 123456, tCat = 20 </td>
<td align = "center" > True, True </td>
<td align = "center" > False, True </td>
<td align = "center" ><font color = "FF0000"> fail </font></td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 3.4 </td>
<td align = "center" > tName = "Bob", tValue = 12.3456, tCat = 20 </td>
<td align = "center" > True, True </td>
<td align = "center" > True, True </td>
<td align = "center" ><font color = "00FF00">pass </font></td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 3.5 </td>
<td align = "center" > tName = "Bob", tValue = -12.3456, tCat = 20 </td>
<td align = "center" > True, True </td>
<td align = "center" > True, False </td>
<td align = "center" ><font color = "FF0000"> fail </font></td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 3.6 </td> 
<td align = "center" > tName = "Bob", tValue = 123456, tCat = -20 </td>
<td align = "center" > True, True </td>
<td align = "center" > True, True </td>
<td align = "center" ><font color = "00FF00"> pass </font></td>
<td align = "center" > 4.21 18:30 </td>
<td align = "center" > ★★★★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
	<td align = "center" >4</td>
	<td align = "center" >testTransactionTime</td>
	<td align = "center" >transactionTime</td>
	<td align = "center" >void</td>
	<td align = "center" >new Date()</td>
	<td align = "center" >new Date()</td>
	<td align = "center" ><font color = "00FF00">pass</font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>5.1</td>
	<td rowspan="2">setTransactionNameTest</td>
	<td rowspan="2">setTransactionName</td>
	<td align = "center" >abcdefghijklmnopqrstuvwxyz</td>
	<td align = "center" >abcdefghijklmnopqrstuvwxyz</td>
	<td align = "center" >abcdefghijklmnopqrstuvwxy</td>
	<td align = "center" ><font color = "FF0000"> fail </font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>5.2</td>
	<td align = "center" >Paul George</td>
	<td align = "center" >Paul George</td>
	<td align = "center" >abcdefghijklmnopqrstuvwxy</td>
	<td align = "center" ><font color = "FF0000"> fail </font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>6.1</td>
	<td rowspan="3">setTransactionValueTest</td>
	<td rowspan="3">setTransactionValue</td>
	<td align = "center" >new BigDecimal("-66.66")</td>
	<td align = "center" >null</td>
	<td align = "center" >null</td>
	<td align = "center" ><font color = "00FF00">pass</font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>6.2</td>
	<td align = "center" >new BigDecimal("12345")</td>
	<td align = "center" >new BigDecimal("12345")</td>
	<td align = "center" >new BigDecimal("12345")</td>
	<td align = "center" ><font color = "00FF00">pass</font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>6.3</td>
	<td align = "center" >new BigDecimal("6789")</td>
	<td align = "center" >new BigDecimal("6789")</td>
	<td align = "center" >new BigDecimal(12345")</td>
	<td align = "center" ><font color = "FF0000"> fail </font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>7.1</td>
	<td rowspan="4">setTransactionCategoryTest</td>
	<td rowspan="4">setTransactionCategory</td>
	<td align = "center" >1</td>
	<td align = "center" >1</td>
	<td align = "center" >1</td>
	<td align = "center" ><font color = "00FF00">pass</font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>7.2</td>
	<td align = "center" >0</td>
	<td align = "center" >1</td>
	<td align = "center" >0</td>
	<td align = "center" ><font color = "FF0000"> fail </font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>7.3</td>
	<td align = "center" >20</td>
	<td align = "center" >20</td>
	<td align = "center" >20</td>
	<td align = "center" ><font color = "00FF00">pass</font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>
<tr>
	<td>7.4</td>
	<td align = "center" >-5</td>
	<td align = "center" >20</td>
	<td align = "center" >20</td>
	<td align = "center" ><font color = "00FF00">pass</font></td>
	<td align = "center" >4.22</td>
	<td align = "center" >★★★</td>
	<td align = "center" >Qiwen Wang</td>
</tr>

<tr>
<td align = "center" > 6 </td>
<td align = "center" > testTypeName </td>
<td align = "center" > transactionName </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = 20 </td>
<td align = "center" > True </td>
<td align = "center" > True </td> 
<td align = "center" > <font color = "00FF00" >pass</font> </td>
<td align = "center" > 4.21 20:30 </td>
<td align = "center" > ★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 7 </td>
<td align = "center" > testTypeValue </td>
<td align = "center" > transactionValue </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = 20 </td>
<td align = "center" > True </td>
<td align = "center" > True </td> 
<td align = "center" ><font color = "00FF00"> pass </font></td>
<td align = "center" > 4.21 20:45 </td>
<td align = "center" > ★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 8 </td>
<td align = "center" > testTypeCat </td>
<td align = "center" > transactionCategory </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = 20 </td>
<td align = "center" > True </td>
<td align = "center" > True </td> 
<td align = "center" ><font color = "00FF00"> pass </font></td>
<td align = "center" > 4.21 20:51 </td>
<td align = "center" > ★ </td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 9 </td>
<td align = "center" > testToString </td>
<td align = "center" > toString </td>
<td align = "center" > tName = "test", tValue = "100.00", tCat = 1 </td>
<td align = "center" > test - ￥100.00 </td>
<td align = "center" > Mon Apr 26 16:59:05 CST 2021test - ￥100.00 </td>
<td align = "center" ><font color = "FF0000"> fail </font></td>
<td align = "center" >4.21 18:24 </td>
<td align = "center" > ★★ </td>
<td align = "center" > Zhiwen Chen </td>
</tr>

<tr>
<td align = "center" > 10 </td>
<td align = "center" > testTime </td>
<td align = "center" > BoCTransaction and setTransactionTime </td>
<td align = "center" > tName = "Bob", tValue = 123456, tCat = 20, tTime = Date + (2 day) </td>
<td align = "center" > Wed Apr 28 17:02:58 CST 2021 </td>
<td align = "center" > Mon Apr 26 17:02:58 CST 2021 </td>
<td align = "center" ><font color = "FF0000"> fail </font></td>
<td align = "center" >4.21 18:51 </td>
<td align = "center" >★★★ </td>
<td align = "center" > Zhiwen Chen </td>
</tr> 
</table>

<br>

<h4>Logs of Bugs</h4>
</br>

**1.** A bug of **BoCTransaction_DefaultConstructer** : there is a bug in test **No.1**.

**(Edit in 4.24 18:24)**
**★★★**
1.**Issue:** When there is no parameters pass into the Class *BoCTransaction Constructor*, it should create an empty transaction 
called *"[Pending Transaction]"* where the category is unknown. But in the test it default its name as *bocTransactionTest@185a6e9*.</br>
**Solution:** Add a if condition to check whether it create a normal transaction or default empty transaction. When the constructer create a default empty transaction toString method will return a name of *"[Pending Transaction]"* into transactionCategory where its value is 0.


**Origin code**
```
public BoCTransaction() {
	transactionName = null;
	transactionValue = null;
	transactionCategory = 0;
	stransactionTime = null;
}
    .
    .
    .
public String toString() {
        return transactionName + " - ￥" + transactionValue.toString();
}
```

**Fixed code**
```
public BoCTransaction() {
	transactionName = null;
	transactionValue = null;
	transactionCategory = 0;
	stransactionTime = null;
	}
    .
    .
    .
public String toString() {
    if(transactionValue() == null && transactionTime() == null && transactionCategory() == 0) {
	return "Pending Transaction";
	}
        else{ return transactionName + " - ￥" + transactionValue.toString(); }
}
```

**2.** Bugs of **BoCTransaction_Constructor** There are two bugs in test **No.** 3.3 and **No.** 3.5
**(Edit in 4.26 15:09)**
**★★★★**
1. **Issue:** For BoCTransaction_Constructor, when there is a name whose length is larger than 25, which means its name have over 25 characters, return of function *transactionName* should not be as same as what it pass into constructer.</br>

**Solution:** There are two solutions, the first one is throw an Error, however, if this function sent an error and return the *main function*, the main function will stop and need users reopen the App. So we choose the second solution, we cut out the first 25 characters of the *String tName*.</br>

2. **Issue:**For BoCTransaction_Constructor, it must recieve a possitive BigDecimal value names tValue. However, when there is a negitive BigDecimal Value passes into the Constructer, the tValue will also be set as this negitive number.</br>

**Solution**
There are also two solutions, the first solution is as same as the above one - sent an error message to warn, but it will cause the class BoCApp quit directly. So we choose another one, if the input transactionValue is an negitive number. The constructer will set the tValue as *null*

**Origin code**
```
public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
	transactionName = tName;
	transactionValue = tValue;
	transactionCategory = tCat;
	transactionTime = new Date();
}
```
</br>

**Fixed code**
```
public BoCTransaction(String tName, BigDecimal tValue, int tCat) {
	if(tName.length() > 25) {
		tName = tName.substring(0,25);
	}
	transactionName = tName;
        if(tValue.compareTo(new BigDecimal(0)) == -1) {
		tValue = null;
	}
	transactionValue = tValue;
	transactionCategory = tCat;
	transactionTime = new Date();
}
```

**3.** A Bug of **toString Override**. There is one bug in test 8 </br>

1. **Issue** When call the toString of Class Transaction, it only return transactionName and transactionValue.However, it actually should output the transactionDate, transactionName and transactionValue.</br>
   
 **Solution** add the transactionTime before the return of toString.</br>

 **Origin code**
 ```
@Override
	public String toString() {
		return transactionName + " - ¥" + transactionValue.toString();
	}
 ```
 
**Fixed code**
```
public String toString() {
	if(transactionValue() == null && transactionTime() == null && transactionCategory() == 0) {
		return "Pending Transaction";
	}
	else {return "(" + transactionTime + ")" + transactionName + " - ¥" + transactionValue.toString();}
}
```

4. Two bugs in setTransactionName

> Bugs in method **_setTransactionName_**
> There are <u>two</u> bugs tested by test no.2 above. 
> 1. As the variable **_transactionName_** can only be set a real value once, <u>the first bug</u> occurs because the method didn't check if the variable **_transactionName_** already had a real value. So in the method **_setTransactionName_**.
> Solution to this bug: I add a judgement to check if the variable **_transactionValue_** is null.
> origin code:
> ```
> if (tValue.compareTo(new BigDecimal("0.00")) == 1)
> ```
> new code:
> ```
> if (tValue.compareTo(new BigDecimal("0.00")) == 1 && transactionValue == null)
> ```
> 2. The variable **_transactionName_** should be limited to 25 chars but the method doesn't check it, this is <u>the second bug</u>. Solution to this bug:
> 
> **origin code**:
> ```
> transactionName = tName;
> ```
> **new code**:
> ```
> if(tName.length() > 25) {
>   transactionName = tName.substring(0,25);
> } else {
>	transactionName = tName;
> }
> ```
5. Two bugs in setTransactionValue
> Bugs in method **_setTransactionValue_**
> There is <u>one</u> bugs tested by test no.3 above. 
> 1. As the variable **_transactionValue_** can only be set a real value once, <u>the bug</u> occurs because the method didn't check if the variable **_transactionValue_** already had a real value. So in the method **_setTransactionName_**.
> Solution to this bug: I add a judgement to check if the variable **_transactionValue_** is null.
> 
> **origin code:**
> ```
> if (tValue.compareTo(new BigDecimal("0.00")) == 1)
> ```
> **new code:** 
> ```
> if (tValue.compareTo(new BigDecimal("0.00")) == 1 && transactionValue == null)
> ```



### Report App

|[----Go to Above----](#above)|

Author: Zhiwen Chen, Zhihang Zhu

<table border = "1">
    <thead>
        <caption>bug in BoCAPP main</caption>
        <tr>
            <th>No.</th>
            <th>Target methods</th>
            <th>Test Name</th>
            <th>Input</th>
            <th>Output</th>
            <th>Expected</th>
            <th>Status</th>
            <th>Time</th>
            <th>Importance</th>
        </tr>
    </thead>
    <tr>
        <td>1.1</td>
        <td>Main</td>
        <td>testMain1</td>
        <td>"Z"</td>
        <td>"Something went wrong: java.lang.NumberFormatException: For input string: "Z""</td>
        <td>"Command not recognized"</td>
        <td>fail</td>
        <td>4.29</td>
        <td>★★★</td>
    </tr>
    <tr>
        <td>1.2</td>
        <td>Main</td>
        <td>testMain2</td>
        <td>"4"</td>
        <td></td>
        <td>"The category number does not exist"</td>
        <td>fail</td>
        <td>4.29</td>
        <td>★★★</td>
    </tr>
<table border = "1">
    <thead>
        <caption>bug in BoCAPP CategoryOverview</caption>
        <tr>
            <th>No.</th>
            <th>Target methods</th>
            <th>Test Name</th>
            <th>Input</th>
            <th>Output</th>
            <th>Expected</th>
            <th>Status</th>
            <th>Time</th>
            <th>Importance</th>
        </tr>
    </thead>
    <tr>
        <td>2.1</td>
        <td>CategoryOverview</td>
        <td>test1</td>
        <td>BoCApp.UserCategories.add(new BoCCategory("Unknown"));<br>
		BoCCategory BillsCategory = new BoCCategory("Bills");<br>
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));<br>
		BoCApp.UserCategories.add(BillsCategory);<br>
		BoCCategory Groceries = new BoCCategory("Groceries");<br>
		Groceries.setCategoryBudget(new BigDecimal("75.00"));<br>
		BoCApp.UserCategories.add(Groceries);<br>
		BoCCategory SocialSpending = new BoCCategory("Social");<br>
		SocialSpending.setCategoryBudget(new BigDecimal("100.00"));<br>
		BoCApp.UserCategories.add(SocialSpending);<br></td>
        <td>1) Unknown(?0.00) - Est. ?850.00 (?850.00 Overspent)<br>
            1) Bills(?120.00) - Est. ?112.99 (?7.01 Remaining)<br>
            2) Groceries(?75.00) - Est. ?31.00 (?44.00 Remaining)<br>
            3) Social(?100.00) - Est. ?22.49 (?77.51 Remaining)<br></td>
        <td>1) Unknown(?0.00) - Est. ?850.00 (?850.00 Overspent)<br>
            1) Bills(?120.00) - Est. ?112.99 (?7.01 Remaining)<br>
            2) Groceries(?75.00) - Est. ?31.00 (?44.00 Remaining)<br>
            3) Social(?100.00) - Est. ?22.49 (?77.51 Remaining)<br></td>
        <td><font color="00FF00">pass</font></td>
        <td>4.27</td>
        <td>★</td>
    </tr>
    <tr>
        <td>2.2</td>
        <td>CategoryOverview</td>
        <td>test2</td>
        <td>null</td>
        <td>null</td>
        <td>(Throw exception)"No category include.\n"</td>
        <td><font color="#FF0000">fail</font> </td>
         <td>4.27</td>
        <td>★★★</td>
    </tr>
</table>


<table border="1">
    <tr>
        <th>No.</th>
        <th>Tests name</th>
        <th>Target methods</th>
        <th>Input</th>
        <th>Output</th>
        <th>Expected</th>
        <th>Status</th>
        <th> time </th>
        <th> importance </th>
        <th> Test Author </th>
   </tr>
   <tr>
        <td rowspan="2">3</td>
        <td align = "center" >testListTransactionsForCategory1</td>
        <td rowspan="2">ListTransactionsForCategory(int chosenCategory)</td>
        <td align = "center" >3</td>
        <td align = "center" >6) (Tue Apr 27 15:21:34 CST 2021) RockCity Drinks - ¥8.50</br>7) (Tue Apr 27 15:21:34 CST 2021) The Mooch - ¥13.99</td>
        <td align = "center" >3) (Tue Apr 27 15:21:34 CST 2021) RockCity Drinks - ¥8.50</br>3) (Tue Apr 27 15:21:34 CST 2021) The Mooch - ¥13.99</td>
        <td align = "center" ><font color = "FF0000"> fail </font></td>
        <td align = "center" >4.28</td>
        <td align = "center" >★★★</td>
        <td align = "center" >Qiwen Wang</td>
   </tr>
   <tr>
        <td align = "center" >testListTransactionsForCategory2</td>
        <td align = "center" >0</td>
        <td align = "center" >1) (Tue Apr 27 15:25:33 CST 2021) Rent - ¥850.00</td>
        <td align = "center" >0) (Tue Apr 27 15:25:33 CST 2021) Rent - ¥850.00</td>
        <td align = "center" ><font color = "FF0000"> fail </font></td>
        <td align = "center" >4.28</td>
        <td align = "center" >★★★</td>
        <td align = "center" >Qiwen Wang</td>
   </tr>
</table>

<table border = "1">
    <thead>
        <caption>Report for BoCAPP AddTransaction</caption>
        <tr>
            <th>No.</th>
            <th>Target methods</th>
            <th>Test Name</th>
            <th>Input</th>
            <th>Output</th>
            <th>Expected</th>
            <th>Status</th>
            <th>Time</th>
            <th>Importance</th>
        </tr>
    </thead>
    <tr>
        <td>4.1</td>
        <td>AddTransaction</td>
        <td>test1</td>
        <td> \nFirst_test\n100.00\n1\n</td>
        <td> Transaction added</td>
        <td> First_test(￥100.00) was added to Bills</td>
        <td> fail </td>
        <th>4.27 21.34</th>
        <th>★★★</th>
    </tr>
     <tr>
        <td>4.2</td>
        <td>AddTransaction</td>
        <td>test2</td>
        <td> \n\n100.00\n1\n</td>
        <td> null</td>
        <td> null</td>
        <td> pass</td>
        <th>4.27 21.34</th>
        <th>★</th>
    </tr>
    <tr>
        <td>4.3</td>
        <td>AddTransaction</td>
        <td>test3</td>
        <td> \nczw\n\n1\n</td>
        <td> null</td>
        <td> null</td>
        <td> fail</td>
        <th>4.27 21.36</th>
        <th>★★★</th>
    </tr>
</table>

<table border="1">
<tr>
 <th align = "center" > No. </th>
 <th align = "center" > Tests name </th>
 <th align = "center" > Target method </th>
 <th align = "center" > Input </th>
 <th align = "center" > Output </th>
 <th align = "center" > Expected </th>
 <th align = "center" > status </th>
 <th align = "center" > time </th>
 <th align = "center" > importance </th>
 <th align = "center" > Test Author </th>
</tr>

<tr>
<td align = "center" > 5.1 </td>
<td rowspan = 6 align = "center" > testChangeTransactionCategory </td>
<td rowspan = 6 align = "center" > BoCApp_ChangeTransactionCategory </td>
<td align = "center" > (System.in) 2, 2 </td>
<td > 1) Unknown($0.00) - Est. $850.00 ($850.00 Overspent) </br>
2) Bills($120.00) - Est. $112.99 ($7.01 Remaining) </br>
3) Groceries($75.00) - Est. $106.00 ($31.00 Overspent) </br>
4) Social($100.00) - Est. $22.49 ($77.51 Remaining) </br>
<td align = "center" > 0) Unknown($0.00) - Est. $850.00 ($850.00 Overspent) </br>
        			1) Bills($120.00) - Est. $75.00 ($45.00 Remaining) </br>
        			2) Groceries($75.00) - Est. $68.99 ($6.01 Remaining) </br>
        			3) Social($100.00) - Est. $22.49 ($77.51 Remaining) </br>
</td>
<td align = "center" ><font color = "FF0000"> fail </font> </td>
<td align = "center" > 4.28 5:04 </td>
<td align = "center"> ★★★★</td>
<td align = "center" > Zhiyu Dong </td> 



<tr>
<td align = "center" > 5.2 </td>
<td align = "center" > (System.in) 2), 2, 2 </td>
<td align = "center" > Something went wrong: java.lang.NumberFormatException: For input string: "2)" </td>
<td align = "center" >Invaild input, please enter again:</td>
<td align = "center" ><font color = "FF0000"> fail </font> </td>
<td align = "center" > 4.28 5:15 </td>
<td align = "center"> ★★</td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 5.3 </td>
<td align = "center" > (System.in) \n, 2, 2 </td>
<td align = "center" > Something went wrong: java.lang.NumberFormatException: For input string: "" </td>
<td align = "center" >Invaild input, please enter again:</td>
<td align = "center" ><font color = "FF0000"> fail </font> </td>
<td align = "center" > 4.28 5:18 </td>
<td align = "center"> ★★</td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 5.4 </td>
<td align = "center" > (System.in) 10, 2, 2 </td>
<td align = "center"> Something went wrong: java.lang.IndexOutOfBoundsException: Index 9 out of bounds for length 7 </td>
<td align = "center" >Can't find the category, please enter again:</td>
<td align = "center" ><font color = "FF0000"> fail </font> </td>
<td align = "center" > 4.28 5:18 </td>
<td align = "center"> ★★</td>
<td align = "center" > Zhiyu Dong </td>
</tr>


<tr>
<td align = "center" > 5.5 </td>
<td align = "center" > (System.in) 2, 5, 2 </td>
<td align = "center"> Something went wrong: java.lang.IndexOutOfBoundsException: Index 5 out of bounds for length 4 </td>
<td align = "center" >"The category number does not exist, please enter again:"</td>
<td align = "center" ><font color = "FF0000"> fail </font> </td>
<td align = "center" > 4.28 5:18 </td>
<td align = "center"> ★★</td>
<td align = "center" > Zhiyu Dong </td>
</tr>

<tr>
<td align = "center" > 5.6 </td>
<td align = "center" > (System.in) abs, 2, 2 </td>
<td align = "center"> Something went wrong: java.lang.NumberFormatException: For input string: "abs" </td>
<td align = "center" >Invaild input, please enter again:</td>
<td align = "center" ><font color = "FF0000"> fail </font> </td>
<td align = "center" > 4.28 5:18 </td>
<td align = "center"> ★★</td>
<td align = "center" > Zhiyu Dong </td>
</tr>
</table>

<table border = "1">
    <thead>
        <caption>Report for BoCAPP AddCategory</caption>
        <tr>
            <th>No.</th>
            <th>Target methods</th>
            <th>Test Name</th>
            <th>Input</th>
            <th>Output</th>
            <th>Expected</th>
            <th>Status</th>
            <th>Time</th>
            <th>Importance</th>
        </tr>
    </thead>
    <tr>
        <td>6.1</td>
        <td>AddCategory</td>
        <td>test1</td>
        <td>\nFirst_test\n100.00\n</td>
        <td>First_test",new BigDecimal("100.00")</td>
        <td>First_test",new BigDecimal("100.00")</td>
        <td>pass</td>
        <td>4.27 18.01</td>
        <td>★</td>
    </tr>
    <tr>
        <td>6.2</td>
        <td>AddCategory</td>
        <td>test2</td>
        <td>\n\n100.00\n</td>
        <td> ,new BigDecimal("100.00")</td>
        <td>New Category",new BigDecimal("100.00")</td>
        <td>fail</td>
        <td>4.27 18.03</td>
        <td>★★</td>
    </tr>
    <tr>
        <td>6.3</td>
        <td>AddCategory</td>
        <td>test3</td>
        <td>\nthis_is_a_reallyyyyyyyyyyy_long_test\n123.45\n</td>
        <td>this_is_a_reallyyyyyyyyyyy_long_test",new BigDecimal("123.45")</td>
        <td>invaild input!</td>
        <td>fail</td>
        <td>4.27 18.03</td>
        <td>★★★</td>
    </tr>
</table>

<h4>Logs for bugs in BoCApp</h4>

> Bugs in method **Main**
> There are <u>two</u> bugs in tests above

> Expected: if the entered target input is invaild like "Z" or other forms, this method should print the error message "Command not recognized", which informed user of the reasons.
> Actual: the method print out the "Something went wrong" with the exception happened in the function Integer.parseInt, while the error message "Command not recognized" can't be shown if the exception happened.

> Expected: fi the entered target input is number for category and the category ID is not in the program, this method should print out the error message "The category number does not exist", which informed user of the reasons.
> Actual: the method print out nothing like nothing just happened, while user may think there is nothing happened. It's difficult for user to check whether the category ID exists or no transactions exists in the category.

>Modified scheme:
>origin code:
>```
>while (in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("T")) {
					ListTransactions();
				} else if (s.equals("O")) {
					CategoryOverview();
				} else if (s.equals("C")) {
					ChangeTransactionCategory(in);
				} else if (s.equals("N")) {
					AddCategory(in);
				} else if (s.equals("A")) {
					AddTransaction(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1) {
					ListTransactionsForCategory((int) Integer.parseInt(s));
				} else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}

			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		}
>```

>new code:
>```
>   while (in.hasNextLine()) {
			String s = in.next();
			try {
				if (s.equals("T")) {
					ListTransactions();
				} else if (s.equals("O")) {
					CategoryOverview();
				} else if (s.equals("C")) {
					ChangeTransactionCategory(in);
				} else if (s.equals("N")) {
					AddCategory(in);
				} else if (s.equals("A")) {
					AddTransaction(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1 && Integer.parseInt(s) < UserCategories.size()) {
					ListTransactionsForCategory((int) Integer.parseInt(s));
				} else {
					System.out.println("The category number does not exist");   // Focus on the category number, if category number doesn't exist, print the relative error message
				}
			} catch (Exception e) {    // When user input an invaild choice string, the program should print the error message
				System.out.println("Command not recognised");
			}
			System.out.println(
					"\nWhat do you want to do?\n O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it");
		}
>```

<h4>Logs for bugs</h4>

> Bugs in method **CategoryOverview**
> There is only <u>one</u> bug in test No.2 above.
> 
> Expected: if the list of category is not empty, this method should return the list in a settled format.If the list of category is empty, the method should return a wrong message to tell the users the list of category is empty,users need to add at least one new category then overview it.
>
>actual:
>the method can print the list of category correctly when the list is not empty. But, when the list of category is empty, the method can not print the error method as the test above.

>Modified scheme:
>origin code:
>```
>public static void CategoryOverview() {
>		for (int x = 0; x < UserCategories.size(); x++) {
>			BoCCategory temp = UserCategories.get(x);
>			System.out.println((x + 1) + ") " + temp.toString());
>		}
>	}
>```
>
>new code:
>```
>public static void CategoryOverview() {
>		try{
>			for (int x = 0; x < UserCategories.size(); x++) {
>			BoCCategory temp = UserCategories.get(x);
>			System.out.println(x + ") " + temp.toString());
>		}}catch(Exception e){
>			System.err.println("No category exists in the program");
>		}
>	}
>```

<h4>Logs for bugs in <b><i>BoCApp</i></b></h4>

> Bugs in method **_ListTransactionsForCategory_**
> There is <u>one</u> bugs tested by test no.1 above. 
> 1. The method **_ListTransactionsForCategory_** should print all the transactions with the same category as the input one and state category first, the solution to this bug:
> 
> **origin code:**
> ```
> System.out.println((x+1)) + ") " + temp.toString());
> ```
> **new code:**
> ```
> System.out.println(chosenCategory + ") " + temp.toString());
> ```

 ## Logs for bugs for AddTransaction
>bug1: Unable to successfully display information after adding the Transaction

>bug2: Cannot accept an input category

> **edit in 4/28 10.28**
> **★★★**
> >Here used a 'reEnter' function to receive a cycle call in order to define whether a title's length is legal.
> And also define whether the tvalue is negtive or not, if an ilegal input exists, this will go to the cycle and ask user for another input, uptill it is legal
>***origin code:***
>  
> ```
>private static void AddTransaction(Scanner in) {
>		System.out.println("What is the title of the transaction?");
>		in.nextLine(); // to remove read-in bug
>		String title = in.nextLine();
>		System.out.println("What is the value of the transaction?");
>		BigDecimal tvalue = new BigDecimal(in.nextLine());
>		UserTransactions.add(new BoCTransaction(title, tvalue, 0));
>		System.out.println("[Transaction added]");
>	}
> ```
>***Fixed code:***
>```
>private static void AddTransaction(Scanner in) {
>		boolean reEnter = true;
>		BigDecimal tvalue = new BigDecimal("0.00");
>		System.out.println("What is the title of the transaction?");
>		in.nextLine(); // to remove read-in bug
>		String title = null;
>		while(reEnter == true){
>			// Check the limitation of the transaction name
>			title = in.nextLine();
>			if(title.length() < 25){
>			reEnter = false;
>			}else{
>				System.out.println("Transaction name can't be more than 25 characters, please enter again:");
>			}
>		}
>		System.out.println("What is the value of the transaction?");
>		reEnter = true;
>		while(reEnter == true){
>			try{
>				// Check every limitation of the category value
>				tvalue = new BigDecimal(in.nextLine());
>				reEnter = false;
>				if(tvalue.doubleValue() < 0){
>					System.out.println("The transaction value can't be less than 0, please enter again:");
>					reEnter = true;
>				}
>			}
>			catch(Exception e){
>				// CHeck invaild input
>				System.out.println("Invaild input, please enter agaain:");
>				reEnter = true;
>			}
>		}
>		reEnter = true;
>		System.out.println("Which category will it be?");  // Allow user to enter the category type of the transaction
>		int tCat = -1;
>		while(reEnter == true){
>			try{
>				// Check whether the category exists
>				tCat = Integer.parseInt(in.nextLine());
>				reEnter = false;
>				if(tCat > UserCategories.size()){
>					// If the category doesn't exist, print the error message
>					System.out.println("The category number does not exist, please enter again:");
>					reEnter = true;
>				}
>			}catch(Exception e){
>				// CHeck invaild input
>				System.out.println("Invaild input, please enter again:");
>				reEnter = true;
>			}
>		}
>		UserTransactions.add(new BoCTransaction(title, tvalue, tCat));
>		UserCategories.get(tCat).addExpense(tvalue);
>		System.out.println(title + "($" + tvalue + ") was added to " + UserCategories.get(tCat).CategoryName());   // Print the confirmation information
>	}
>```

# Log Bugs

>Bugs in the **BoCApp ChangeTransactionCategory** there are 6 bugs in total
>**edit in 4/28 18:54**
> **★★★★**
>1. **Issue:**  </br> When the method changeTransactionCategory get two integers form system, it will print correct transaction informations but move wrong transaction to wrong category. Meanwhile, the budgets of source category didn't reduce but budget of the new category increased. Through our analyzing, firstly, the order of means that shows to users is different from the program get. The order shows to user is that 1), 2), 3), 4) but actually 0), 1), 2), 3). And this issue occurs both on category and transaction.</br>
>**Solution** </br>
>change the order of means items from 1), 2), 3), 4) into  0), 1), 2), 3) to let the order shows to users are as same as the program get. At mean time, when program shows the transaction, make program recieve (System.in - 1) to synchronize all information.Focus on the first problem, the reason that cause this issue is that program only read the tValue of choosen Transaction and change the data of choosen category with the tValue. But the program doesn't change the source category.

> 2. **Issue:** When there are some invalid input pass through the method, this method cannot judge intelligently, it can only rely on the error expection. And it can not have another chance to input again. Meanwhile these invalid input include: return(\n), out off range number, and some strings.</br>
> **Solution**  </br>
> We consider to use for loop to achieve input in lots of times, and add appariate if condition to screen the valid input, otherwise it will return some warning and ask users to input one more time.

>**Origin code**
>```
>	private static void ChangeTransactionCategory(Scanner in) {
>		System.out.println("Which transaction ID?");
>		in.nextLine();
>		int tID = Integer.parseInt(in.nextLine());
>		System.out.println("\t- " + UserTransactions.get(tID - 1).toString());
>		System.out.println("Which category will it move to?");
>		CategoryOverview();
>		int newCat = Integer.parseInt(in.nextLine());
>		BoCTransaction temp = UserTransactions.get(tID);
>		temp.setTransactionCategory(newCat);
>		UserTransactions.set(tID, temp);
>		BoCCategory temp2 = UserCategories.get(newCat);
>		temp2.addExpense(temp.transactionValue());
>		UserCategories.set(newCat, temp2);
>   }
>```

>**Fixed code**
>```
>private static void ChangeTransactionCategory(Scanner in) {
>		boolean reEnter = true;
>		int newCat = -1;
>		System.out.println("Which transaction ID?");
>		in.nextLine();
>		int tID = 0;
>		while(reEnter == true){
>			try{
>				// The transaction must exist, if not, 
>				tID = Integer.parseInt(in.nextLine());
>				reEnter = false;
>				if(tID > UserTransactions.size()){
>					System.out.println("Can't find the category, please enter again:");
>					reEnter = true;
>				}
>			}catch(Exception e){
>				System.out.println("Invaild input, please enter again:");
>			}
>		}
>		reEnter = true;
>		System.out.println("- " + UserTransactions.get(tID - 1).toString());
>		System.out.println("Which category will it move to?");
>		CategoryOverview();
>		while(reEnter == true){
>			try{
>				// Check whether the input is vaild and the category exists.
>				newCat = Integer.parseInt(in.nextLine());
>				reEnter = false;
>				if(newCat > UserCategories.size()){
>					System.out.println("The category number does not exist, please enter again:");
>					reEnter = true;
>				}
>				System.out.println("Invaild input, please enter again:");
>				reEnter = true;
>			}
>		}
>		BoCTransaction temp = UserTransactions.get(tID - 1);
>		BoCCategory temp1 = UserCategories.get(temp.transactionCategory());
>		UserTransactions.set(tID - 1, temp);
>		// Add the value for target category, reduce the previous category
>		BoCCategory temp2 = UserCategories.get(newCat);
>		temp2.addExpense(temp.transactionValue());
>		UserCategories.set(newCat, temp2);
>		System.out.println(temp.transactionName() + "(￥" +temp.transactionValue() + ") was moved to " + temp2.CategoryName() + " from " + temp1.CategoryName());   // Give the confirmation
	}
>``

## Logs for bugs for AddCategory

>bug1: if nothing was inputed into Category name, then a new name "New Category" wil be accpeted,but the origin code miss this function

>bug2: if the input name was larger tha 15, then the programe shoud return'invaild input' ,but the origin code miss this function

> **edit in 4/28 13.21**
> **★★★**
> >Here used a 'reEnter' function to receive a cycle call in order to define whether a title's length is legal.
> And also define whether the tvalue is negtive or not, if an ilegal input exists, this will go to the cycle and ask user for another input, uptill it is legal
>***origin code:***
>```
>private static void AddCategory(Scanner in) {
>		System.out.println("What is the title of the category?");
>		in.nextLine(); // to remove read-in bug
>		String title = in.nextLine();
>		System.out.println("What is the budget for this category?");
>		BigDecimal cbudget = new BigDecimal(in.nextLine());
>		BoCCategory temp = new BoCCategory(title);
>		temp.setCategoryBudget(cbudget);
>		UserCategories.add(temp);
>		System.out.println("[Category added]");
>		CategoryOverview();
>	}
>```
>***Fixed code:***
>```
>private static void AddCategory(Scanner in) {
>		boolean reEnter = true;
>		System.out.println("What is the title of the category?");
>		in.nextLine(); // to remove read-in bug
>		String title = in.nextLine();
>		while(reEnter == true){
>			// If the name is null, give "New Category" for it
>			if(title.length() == 0){
>				title = "New Category";
>				reEnter = false;
>			}else if(title.length() < 15){   //Check the limitation of the title
>				reEnter = false;
>			}else{
>				System.out.println("Category name can't be more than 15 characters, please enter again:");
>			}
>		}
>		// Check whether the budget value is vaild
>		System.out.println("What is the budget for this category?");
>		reEnter = true;
>		BigDecimal cbudget = new BigDecimal("0.00");
>		while(reEnter == true){
>			try{
>				// Check the invaild input and vaild value
>				cbudget = new BigDecimal(in.nextLine());
>				reEnter = false;
>				if(cbudget.doubleValue() <= 0){
>					System.out.println("The initial budget can't be less than 0, please enter again:");
>					reEnter = true;
>				}
>			}catch(Exception e){
>				System.out.println("Invaild input, please enter again:");
>			}
>		}
>		BoCCategory temp = new BoCCategory(title);
>		temp.setCategoryBudget(cbudget);
>		UserCategories.add(temp);
>		System.out.println(temp.CategoryName() + " was added, its budget is ¥" + temp.CategoryBudget());   // Give the confirmation
>		CategoryOverview();
>	}
>}
>```
