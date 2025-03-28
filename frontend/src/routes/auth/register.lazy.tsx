import RegisterForm from "@/components/auth/forms/register-form";
import { createLazyFileRoute, Link } from "@tanstack/react-router";

export const Route = createLazyFileRoute("/auth/register")({
    component: Register,
});

function Register() {
    return (
        <div className="flex items-center justify-center h-full bg-neutral-100">
            <div className="flex flex-col items-center justify-center rounded-md gap-4 bg-white py-10">
                <h1 className="text-2xl font-bold">Login</h1>
                <RegisterForm />
                <Link to="/auth/login">Already have an account?</Link>
            </div>
        </div>
    );
}
