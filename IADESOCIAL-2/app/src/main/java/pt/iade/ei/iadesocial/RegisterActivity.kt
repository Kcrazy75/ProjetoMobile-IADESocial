package pt.iade.ei.iadesocial


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.iadesocial.ui.views.LoginView
import com.example.iadesocial.ui.views.SignUpView
import pt.iade.ei.iadesocial.api.RetrofitInstance
import pt.iade.ei.iadesocial.api.UsersRepositoryImplementation
import pt.iade.ei.iadesocial.ui.theme.IADESOCIALTheme
import pt.iade.ei.iadesocial.viewmodels.UsersViewModel

class RegisterActivity : ComponentActivity() {

    private val viewModel by viewModels<UsersViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return UsersViewModel(UsersRepositoryImplementation(RetrofitInstance.api),
                    applicationContext)
                        as T
            }
        }
    })



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()




        setContent {
            IADESOCIALTheme {
                val context = LocalContext.current
                // Passando o ViewModel para o LoginMenu
               SignUpView(viewModel = viewModel)
            }
        }
    }
}
