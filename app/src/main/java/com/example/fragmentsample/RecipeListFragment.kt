package com.example.fragmentsample

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment

class RecipeListFragment: Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("ActivityTest", "onAttach of First Fragment")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ActivityTest", "onDetach of First Fragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_recipe_list, container, false
        )
        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            Column(
                modifier = Modifier
                    .border(border = BorderStroke(1.dp, Color.Black))
                    .padding(16.dp)
            ) {

                Text("THIS IS A COMPOSABLE INSIDE THE FRAGMENT XML")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator()
                Text("NEAT")
                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    // below line is use to add onclick
                    // parameter for our button onclick
                    onClick = {
                        // when user is clicking the button
                        // we are displaying a toast message.
                        val transaction = activity?.supportFragmentManager?.beginTransaction()
                        if (transaction != null) {
                            transaction.replace(R.id.main_container, SecondFragment())
                            transaction.addToBackStack(null)
                            transaction.commit()
                        }


                    },
                    // in below line we are using modifier
                    // which is use to add padding to our button
                    modifier = Modifier.padding(all = Dp(10F)),

                    // below line is use to set or
                    // button as enable or disable.
                    enabled = true,

                    // below line is use to
                    // add border to our button.
                    border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Blue)),

                    // below line is use to add shape for our button.
                    shape = MaterialTheme.shapes.medium,
                ){
                    Text(text = "Load Second Fragment", color = Color.White)
                }

                var customView = HorizontalDottedProgress(LocalContext.current)
                AndroidView(
                    factory = { ctx -> customView
                        .apply { customView = this }
                    },
                    update = { view -> customView = view }
                )

            }
        }

        return view
    }

}





















