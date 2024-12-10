# Coursework2
## Introduction
Approched by Bank of China(Boc), we plan to develop an interesting new app which helps customers to manage personal finance. We choose scenarios and activity diagram to elaborate the process of using the application.
***
### Scenarios
##### In order to show diffrent types of account, we use two Scenarios.
<table>
    <tr>
        <th>Item</th>
        <th>Detail</th>
    </tr>
    <tr>
        <td>Title</td>
        <td>How to manage multi account</td>
    </tr>
    <tr>
        <td>Overview</td>
        <td>
        <b>People</b>: Amber Chen, high income, a multi-account user</br>
        <b>Activity</b>: Check the recent bills and show different categories of the expenditure</br>
        <b>Rationale</b>:An introduction of the app's management function for multi-account
        </td>
    </tr>
    <tr>
        <td>Detail</td>
        <td>
            1.Amber want to know her recent expenditure.</br>
            2.She uses the app and logs in with her account number and password.</br>
            3.The app shows her account's information and check the property of her account.</br>
            4.The app automatically shows the multi-account-user menu for her further operation.</br>
            5.Amber click one of her accounts.</br>
            6.The app show the details of the chosen account.</br>
            7.Amber clicks the "Expenditure Categories" bottom.</br>
            8.The app jumps to the relative page.</br>
            9.Amber clicks the "Electricity Expenditure" bottom.</br>
            10.The app shows the relative information.</br>
            11.Amber clicks the "Edit" bottom.</br>
            12.The app shows all the categories stored in the list.</br>
            13.Amber clicks the "Add" bottom.</br>
            14.The app lets her enter a new category's name.</br>
            15.Amber enters the name and click "Save".</br>
            16.The app updates the information and show the "Expenditure Categories" again.</br>
            17.Amber quits the app.
        </td>
    </tr>
    <tr>
        <td>Note</td>
        <td>
            1.The multi-account-user's menu is slight different from other kinds of account. For example, this menu provide the "Choose Account" Function.</br>
            2.The app will check the account type automatically and display the relative menu.
        </td>
    </tr>
<table>

<table>
    <tr>
        <th>Item</th>
        <th>Detail</th>
    </tr>
    <tr>
        <td>Title</td>
        <td>How to manage multi account</td>
    </tr>
    <tr>
        <td>Overview</td>
        <td>
        <b>People</b>:Steven Zhang, the owner of a joint account</br>
        <b>Activity</b>:Check the account's activities and find all the expenditures from different user in the joint account.</br>
        <b>Rationale</b>:An introduction of the app's management function for joint-account
        </td>
    </tr>
    <tr>
        <td>Detail</td>
        <td>
            1.Steven want to view the joint account information.</br>
            2.He uses the joint account's number and password to log in the app.</br>
            3.The app shows all the users' information and the summary of the account.</br>
            4.The app automatically shows the joint-account-user menu for his further operation.</br>
            5.Steven clicks one of the users.</br>
            6.The app shows the relative expenditure of the target user.</br>
            7.Steven clicks the "Expenditure Categories" bottom.</br>
            8.The app shows the relative information of the chosen user.</br>
            9.Steven quits the app.</br>
        </td>
    </tr>
    <tr>
        <td>Note</td>
        <td>
            1.In the joint-account, different user has different roles. Only the owner and the adminstrators can know all the information of every individual user.</br>
            2.The joint-account-user's menu is slight different from other kinds of account.
            For example, this menu can show all the members' information for the owner.</br>
        </td>
    </tr>
<table>

>Through different scenario, it's easy for both the developers and normal users to understand the function of the application in the simulation of real situation. For example, in scenarios above, we can easily find what should be shown in this application for multi account users and joint account users respectively. 
Also, based on users' view, it's more clear to elaborate the whole process a user using this app from start, which sholud be looin the account, then use functions inside to either check the account's activities or find all the expenditures. Without scenarios, it's hard to represent the whole process in a user's view.




***
### Activity doagram
![alt 属性文本](/docs/Coursework2/image/Activity.jpg)
>Through the active diagram the mian process of this APP can be displayed clearly. The user's operation is directed to different interfaces. Activity diagram can show the important decisions. For example, in this application, choose different functions can achieve different aims like show accounts informatin or cehck the bugets for this month.

***
## Prototypes
<table>
    <tr>
        <th>Names</th>
        <th>Prototypes</th>
        <th>Description</th>
    </tr>
    <tr>
        <td>Index</td>
        <td><img src="/docs/Coursework2/image/Index.jpg"/></td>
        <td>This  is the index when an unlogged user first enters the app. Users can find most of the functions here like transfer money,  scan the QR code and etc,. Users can switch the page though the icons below.</td>
    </tr>
    <tr>
        <td>Login</td>
        <td><img src="/docs/Coursework2/image/Login.png"/></td>
        <td>Users type in his/her own account to login in. Depend on user's account, the page will have different functions. If enter the inexistence account or enter the wrong password, this page will popup the error message. </td>
    </tr>
    <tr>
        <td>Selection</td>
        <td><img src="/docs/Coursework2/image/selection2.jpg"/></td>
        <td>Users can make choices through this page. Users can touch the highlight button to acquire their spending types.</td>
    </tr>
    <tr>
        <td>SpendingType</td>
        <td><img src="/docs/Coursework2/image/Selection.jpg"/></td>
        <td>Here users can check their detailed types of their spend and also they can add and remove any type they want. When they add or remove, a new pie chart will automatically appear.</td>
    </tr>
</table>

