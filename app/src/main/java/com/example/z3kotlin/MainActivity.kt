package com.example.z3kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.todoapp.TaskFragment
import com.example.z3kotlin.ui.theme.Z3KOTLINTheme
import java.util.UUID

class MainActivity : SingleFragmentActivity() {

    override fun createFragment():Fragment{
        val taskId = intent.getSerializableExtra("extraKey", UUID::class.java)
        return TaskFragment.newInstance(taskId!!)
    }

}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Z3KOTLINTheme {
        Greeting("Android")
    }
}