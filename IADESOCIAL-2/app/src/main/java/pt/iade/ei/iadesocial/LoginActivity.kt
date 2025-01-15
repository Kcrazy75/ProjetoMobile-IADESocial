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
import pt.iade.ei.iadesocial.api.RetrofitInstance
import pt.iade.ei.iadesocial.api.UsersRepositoryImplementation
import pt.iade.ei.iadesocial.models.SessionManager
import pt.iade.ei.iadesocial.ui.theme.IADESOCIALTheme
import pt.iade.ei.iadesocial.viewmodels.UsersViewModel

class LoginActivity : ComponentActivity() {

    private val viewModel by viewModels<UsersViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return UsersViewModel(UsersRepositoryImplementation(RetrofitInstance.api),
                    applicationContext)
                        as T
            }
        }
    })

    // Iniciar o SessionManager
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicialize o SessionManager
        sessionManager = SessionManager(applicationContext)

        setContent {
            IADESOCIALTheme {
                val context = LocalContext.current
                // Passando o ViewModel para o LoginMenu
                LoginView(viewModel = viewModel)
            }
        }
    }
}
