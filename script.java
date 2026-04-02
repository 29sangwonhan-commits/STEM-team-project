const chatWindow = document.getElementById('chat-window');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');

// The Core Advice Database
const masterAdvice = `
Depression: Talk to someone you trust, get sunlight, and try small activities.
Anger: Take deep breaths and count to 10 before reacting.
Anxiety: Focus on slow breathing and break tasks into tiny steps.
Nervousness: Practice what worries you and think positive thoughts.`;

// 150+ Response Logic
const responses = {
    "hi": "Hey bestie! ✨ I was hoping you'd stop by. What's the tea?",
    "hello": "Hi there! 🌸 I'm PinkMind AI. How are you feeling today?",
    "sad": "I'm so sorry you're feeling this way. 💗 You can vent to me as long as you need. I'm listening.",
    "bad": "I'm sorry things are tough right now. Remember, you're not alone. I'm here for you.",
    "happy": "That is wonderful! 💖 Happiness looks so good on you. Share that glow!",
    "exam": "Ugh, tests are the worst! 📖 But you're smart and capable. Take a deep breath—you've got this!",
    "test": "Don't let a grade define you. You're doing your best, and that's enough!",
    "thanks": "You are so welcome! 💖 I'm always in your corner.",
    "joke": "Why don't skeletons fight each other? Because they don't have the guts! 😂",
    "bullying": "You deserve to be safe and respected. 🛑 Please talk to a teacher or a trusted adult. You matter!",
    "lonely": "I'm right here with you! 🫂 Maybe try reaching out to a friend or listening to your favorite music?"
};

function addMessage(text, isUser = false) {
    const wrapper = document.createElement('div');
    wrapper.style.display = "flex";
    wrapper.style.justifyContent = isUser ? "flex-end" : "flex-start";
    wrapper.style.marginBottom = "1.5rem";

    const msg = document.createElement('div');
    msg.className = isUser ? "bubble-user" : "bubble-ai";
    msg.innerText = text;

    wrapper.appendChild(msg);
    chatWindow.appendChild(wrapper);
    
    // Auto-scroll to bottom
    chatWindow.scrollTop = chatWindow.scrollHeight;
}

function handleSend() {
    const text = userInput.value.trim();
    if (!text) return;

    // Add user message
    addMessage(text, true);
    userInput.value = '';

    // Confetti trigger for positive vibes
    const lowText = text.toLowerCase();
    if (lowText.includes('happy') || lowText.includes('proud') || lowText.includes('excited')) {
        confetti({
            particleCount: 100,
            spread: 70,
            origin: { y: 0.6 },
            colors: ['#ec4899', '#fbcfe8']
        });
    }

    // AI thinking delay
    setTimeout(() => {
        let foundResponse = "I totally get that. Tell me more? 🌸";
        
        // Check our database for keywords
        for (let key in responses) {
            if (lowText.includes(key)) {
                foundResponse = responses[key];
                break;
            }
        }

        // Add the core guidance to the end of specific responses
        if (lowText.includes('sad') || lowText.includes('stress') || lowText.includes('anxiety')) {
            foundResponse += "\n\n---\nPinkMind Guide:\n" + masterAdvice;
        }

        addMessage(foundResponse, false);
    }, 1000);
}

// Event Listeners
sendBtn.addEventListener('click', handleSend);
userInput.addEventListener('keypress', (e) => {
    if (e.key === 'Enter') handleSend();
});

console.log("PinkMind AI by Kai & Jiwon is running!");
