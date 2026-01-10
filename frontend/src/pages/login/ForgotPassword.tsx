import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Mail, ArrowLeft, CheckCircle } from "lucide-react";
import { Link } from "react-router-dom";
import { useToast } from "@/hooks/use-toast";

export const ForgotPassword = () => {
    const [email, setEmail] = useState("");
    const [isLoading, setIsLoading] = useState(false);
    const [isSubmitted, setIsSubmitted] = useState(false);
    const { toast } = useToast();

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setIsLoading(true);

        // Simulate API call
        setTimeout(() => {
            setIsLoading(false);
            setIsSubmitted(true);
            toast({
                title: "Email đã được gửi!",
                description: "Vui lòng kiểm tra hộp thư của bạn.",
            });
        }, 1500);
    };

    return (
        <div className="min-h-screen bg-gradient-to-br from-background via-background to-primary/5 flex items-center justify-center p-4">
            {/* Background decoration */}
            <div className="absolute inset-0 overflow-hidden pointer-events-none">
                <div className="absolute -top-40 -right-40 w-80 h-80 bg-primary/10 rounded-full blur-3xl" />
                <div className="absolute -bottom-40 -left-40 w-80 h-80 bg-primary/10 rounded-full blur-3xl" />
            </div>

            <Card className="w-full max-w-md relative z-10 border-border/50 shadow-2xl backdrop-blur-sm bg-card/95">
                <CardHeader className="text-center space-y-2">
                    <div className="mx-auto w-12 h-12 bg-primary/10 rounded-xl flex items-center justify-center mb-2">
                        {isSubmitted ? (
                            <CheckCircle className="w-6 h-6 text-primary" />
                        ) : (
                            <Mail className="w-6 h-6 text-primary" />
                        )}
                    </div>
                    <CardTitle className="text-2xl font-bold">
                        {isSubmitted ? "Kiểm tra email" : "Quên mật khẩu?"}
                    </CardTitle>
                    <CardDescription>
                        {isSubmitted
                            ? "Chúng tôi đã gửi hướng dẫn đặt lại mật khẩu đến email của bạn."
                            : "Nhập email của bạn và chúng tôi sẽ gửi hướng dẫn đặt lại mật khẩu."}
                    </CardDescription>
                </CardHeader>

                <CardContent>
                    {!isSubmitted ? (
                        <form onSubmit={handleSubmit} className="space-y-4">
                            <div className="space-y-2">
                                <Label htmlFor="email">Email</Label>
                                <div className="relative">
                                    <Mail className="absolute left-3 top-1/2 -translate-y-1/2 w-4 h-4 text-muted-foreground" />
                                    <Input
                                        id="email"
                                        type="email"
                                        placeholder="email@example.com"
                                        className="pl-10"
                                        value={email}
                                        onChange={(e) => setEmail(e.target.value)}
                                        required
                                    />
                                </div>
                            </div>

                            <Button type="submit" className="w-full" disabled={isLoading}>
                                {isLoading ? (
                                    <div className="w-5 h-5 border-2 border-primary-foreground/30 border-t-primary-foreground rounded-full animate-spin" />
                                ) : (
                                    "Gửi hướng dẫn"
                                )}
                            </Button>
                        </form>
                    ) : (
                        <div className="space-y-4">
                            <p className="text-sm text-muted-foreground text-center">
                                Không nhận được email?{" "}
                                <button
                                    onClick={() => setIsSubmitted(false)}
                                    className="text-primary hover:underline"
                                >
                                    Thử lại
                                </button>
                            </p>
                        </div>
                    )}

                    <div className="mt-6">
                        <Link
                            to="/"
                            className="flex items-center justify-center gap-2 text-sm text-muted-foreground hover:text-foreground transition-colors"
                        >
                            <ArrowLeft className="w-4 h-4" />
                            Quay lại đăng nhập
                        </Link>
                    </div>
                </CardContent>
            </Card>
        </div>
    );
};

export default ForgotPassword;
