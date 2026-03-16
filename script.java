function focusChat() {
    document.getElementById('userInput').focus();
    document.getElementById('chatWidget').style.borderColor = "#FFC1CC";
    setTimeout(() => { document.getElementById('chatWidget').style.borderColor = "#800020"; }, 1000);
}

function handleSend() {
    const input = document.getElementById('userInput');
    const container = document.getElementById('chatMessages');
    
    if (input.value.trim() === "") return;

    // User Message
    const userDiv = document.createElement('div');
    userDiv.className = 'msg user';
    userDiv.innerText = input.value;
    container.appendChild(userDiv);

    const userText = input.value.toLowerCase();
    input.value = "";

    // AI Response Simulation
    setTimeout(() => {
        const botDiv = document.createElement('div');
        botDiv.className = 'msg bot';
        
        if (userText.includes("sad") || userText.includes("bad")) {
            botDiv.innerText = "I'm so sorry you're feeling this way. Remember that it's okay to not be okay. I'm here to listen.";
        } else if (userText.includes("hello") || userText.includes("hi")) {
            botDiv.innerText = "Hello! I am your MindfulAI. How can I support you today?";
        } else {
            botDiv.innerText = "Thank you for sharing that with me. Please tell me more, I'm listening.";
        }
        
        container.appendChild(botDiv);
        container.scrollTop = container.scrollHeight;
    }, 1000);
}

// Allow "Enter" key to send message
document.getElementById('userInput').addEventListener('keypress', function (e) {
    if (e.key === 'Enter') handleSend();
});
