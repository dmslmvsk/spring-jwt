import { createFileRoute, Link } from "@tanstack/react-router";

export const Route = createFileRoute("/")({
    component: Index,
});

function Index() {
    return (
        <div className="h-full w-full">
            <Link to="/auth/login">Login</Link>
            <Link to="/auth/register">Register</Link>
        </div>
    );
}
