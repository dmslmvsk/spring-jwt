import LoginForm from "./components/auth/forms/login-form";
import RegisterForm from "./components/auth/forms/register-form";

function App() {
    return (
        <div className="flex items-center justify-center">
            <LoginForm />
            <RegisterForm />
        </div>
    );
}

export default App;
