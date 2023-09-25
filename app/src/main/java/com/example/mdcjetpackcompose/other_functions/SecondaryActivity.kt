package com.example.mdcjetpackcompose.other_functions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mdcjetpackcompose.ui.theme.MDCJetpackcomposeTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview(){

    /*//List that contains the student's name
    val students =
        remember{mutableStateListOf("Miguel", "Juan", "Jose")}
    //val where is saved the student that want to add to the list
    val newStudentName = remember { mutableStateOf("") }*/
    
    MDCJetpackcomposeTheme {
        /*StudenList(
            students,
            //when the button is clicked, add the input to the list and delete the text
            {
                students.add(newStudentName.value)
                newStudentName.value = ""
            },
            newStudentName.value,
             {newStudent -> newStudentName.value = newStudent}
        )*/
        MainScreen()

    }

}

/***
 * @param students list with all students
 * @param onButtonClick function (lambda, callback ) that is triggered when button is clicked
 * @param studentName var where the user's input is saved
 * @param onStudentNameChanged function that execute when the user change the textfiel value
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudenList(students: List<String>,
               onButtonClick : () -> Unit,
                studentName: String,
               onStudentNameChanged: (String) -> Unit
               ) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        for(student in students) {
            Text(text = student)
        }

        OutlinedTextField(
            value = studentName,
            label = { Text("Label") },
            onValueChange = onStudentNameChanged
        )

        Button(
            onClick = onButtonClick
        ) {
            Text(text = "Add")
        }
    }

}



@Composable
fun MainScreen(viewModel: SecondaryViewModel = SecondaryViewModel()){

    val nameState = viewModel.textFieldState.observeAsState("")

    Surface(

        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        MainLayout(
            name = nameState.value,
            onTextFieldChange = {
                newName -> viewModel.onTextFieldChange(newName)
            }
        )

        MessageList(messages = listOf("Test 1", "Test 2", "Test 3"))

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
    name: String,
    onTextFieldChange: (String) -> Unit
) {

    Column (
        modifier = Modifier.fillMaxWidth()
    ) {

        Button(onClick = { /*TODO*/ }) {

        }
        TextField(
            value = name,
            onValueChange = onTextFieldChange
        )

        Text(text = name)
    }

}






































































