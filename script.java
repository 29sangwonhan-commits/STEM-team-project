const mainSite = document.getElementById('main-site');
const chatPage = document.getElementById('chat-page');
const chatWindow = document.getElementById('chat-window');
const userInput = document.getElementById('user-input');
const sendBtn = document.getElementById('send-btn');

// Core advice to append to responses
const masterAdvice = `Depression: Talk to someone you trust, get sunlight, and do small activities.
Anger: Take deep breaths, step away, and count to 10.
Anxiety: Focus on slow breathing and break tasks into small steps.
For all: Get enough sleep, exercise, and consider talking to a counselor.`;

// THE FULL 50+ RESPONSE DATABASE
const responses = {
    "happy": "That is wonderful! 💖 Happiness looks good on you. Try to share a smile with someone today!",
    "excited": "I love that energy! ✨ Channel it into a project or a dance break. You're glowing!",
    "sad": "I'm sending you a huge digital hug. 💗 It's okay to feel this way. Be gentle with yourself today.",
    "tired": "You've been doing a lot. 🛌 It's time to recharge. Take a break from your phone and just breathe.",
    "bored": "Boredom is the spark for creativity! 🎨 Try sketching something or learning a new skill.",
    "stress": "Stress is heavy, but you are stronger. 🌬️ Try the '4-7-8' breathing method to calm down.",
    "exam": "You are more than a grade! 📖 Study in small chunks and remember to hydrate. You've got this!",
    "lonely": "I am right here! 🫂 Try reaching out to a friend or listening to your favorite podcast for company.",
    "angry": "Deep breaths... 😤 Try writing down your anger on paper and then safely ripping it up.",
    "scared": "You are safe. 🛡️ Try to name 5 things you can see right now to stay grounded.",
    "invisible": "I see you and you matter! 🌟 Your voice is important. Don't be afraid to take up space.",
    "phone": "A digital detox might be exactly what you need. 📱 Set your phone aside for 30 minutes.",
    "bullying": "You deserve to be safe and respected. 🛑 Please tell a teacher or a trusted adult immediately.",
    "friend": "Friendship has its ups and downs. 🎀 Honest talk is usually the best way to fix things.",
    "family": "Family can be tough to navigate. 🏠 Find your own quiet corner to relax and be yourself.",
    "body": "Your body is amazing for all it does! 🌸 Treat it with kindness; beauty comes from within.",
    "future": "The future is full of possibilities. 🌈 Don't stress about the 'when'—just focus on 'now'.",
    "failure": "Failure is just a stepping stone to success. 🎓 Every mistake is a lesson learned.",
    "worthless": "You are incredibly valuable. 🕊️ The world is better because you are in it. Never forget that.",
    "anxious": "Anxiety is just a feeling, not your reality. 🌬️ Focus on breathing; this will pass.",
    "nervous": "Nervousness means you care! 🎡 Use that adrenaline to power through your challenge.",
    "motivation": "Motivation starts with one small step. 🚀 Just do one tiny task to get moving.",
    "heartbreak": "Time is a great healer. 💔 Be patient with your heart and surround yourself with love.",
    "english": "For your English test: 📝 Focus on your clear points and evidence. You'll do great!",
    "math": "Math is just logic. 🔢 Take it one step at a time and don't be afraid to ask for help.",
    "science": "Stay curious! 🧪 The world is full of wonder. You're doing a great job learning.",
    "gym": "Exercise is a great mood booster! 🏋️‍♂️ Even a quick walk can change your perspective.",
    "music": "Let the music heal you! 🎧 Put on your favorite song and let the rhythm lift you up.",
    "thanks": "You are so welcome! 💖 I'm always here if you need to talk again.",
    "hello": "Hi bestie! ✨ I'm PinkMind. How can I support your mental wellness today?",
    "hi": "Hey there! ✨ What's on your mind? I'm here to listen.",
    "weather": "Rain or shine, you can have a great day. ☀️ If it's raining, enjoy the cozy vibes!",
    "parents": "Communicating with parents can be hard. 🏠 Try to stay calm and explain how you feel.",
    "grades": "Your grades are just a snapshot of one moment. 📝 Your character matters so much more.",
    "internet": "The internet is a tool—use it for good! 🌐 Remember to take breaks and stay safe.",
    "guilty": "We all make mistakes. 🕊️ Learn the lesson and let go of the shame. You are growing.",
    "confused": "It's okay to not have all the answers. 🧩 Life is a journey of discovery. Take your time.",
    "creative": "Your creativity is your superpower! 🎭 Use it to express yourself and color your world.",
    "hope": "Always keep hope in your heart. 🕯️ Better things are coming your way, I promise.",
    "proud": "I am so proud of you! 🌟 Celebrate your wins, no matter how small they may seem.",
    "crying": "Crying is a healthy release. 🌊 Let it out and then take a deep breath. You'll feel better.",
    "annoyed": "Deep breaths... 🙄 Don't let the small things ruin your day. You're bigger than this.",
    "social": "Social situations can be tricky. 🎡 Just be yourself—that's the best person you can be!",
    "regret": "Don't let the past weigh you down. 🕊️ You are growing every single day. Look forward!",
    "money": "Financial stress is tough. 💸 Focus on the simple, free joys while you work things out.",
    "advice": "My advice? 💡 Be your own best friend. Speak to yourself with the same love you give others.",
    "help": "I'm here! 🆘 If you need urgent help, reach out to a professional or helpline immediately.",
    "joke": "Why don't skeletons fight each other? Because they don't have the guts! 😂",
    "shame": "Shame loses its power when it's shared. 🫂 Talk to someone you trust. You are worthy."
};

function switchToChat() {
    mainSite.classList.add('hidden');
    chatPage.classList.remove('hidden');
    window.scrollTo(0, 0);
}

function addMessage(text, isUser = false) {
    const div = document.createElement('div');
    div.className = isUser ? "flex justify-end" : "flex justify-start";
    const bubble = document.createElement('div');
    bubble.className = isUser ? "chat-bubble-user" : "chat-bubble-ai";
    bubble.innerText = text;
    div.appendChild(bubble);
    chatWindow.appendChild(div);
    chatWindow.scrollTop = chatWindow.scrollHeight;
}

function handleSend() {
    const text = userInput.value.trim();
    const low = text.toLowerCase();
    if (!text) return;

    addMessage(text, true);
    userInput.value = '';

    // Celebration effect
    if (low.includes('happy') || low.includes('excited') || low.includes('proud')) {
        confetti({ particleCount: 150, spread: 70, origin: { y: 0.6 }, colors: ['#ec4899', '#fbcfe8'] });
    }

    // AI Logic: Find matching keyword in the database
    setTimeout(() => {
        let found = false;
        for (let key in responses) {
            if (low.includes(key)) {
                addMessage(responses[key] + "\n\n---\nPinkMind Guidance:\n" + masterAdvice);
                found = true;
                break;
            }
        }
        if (!found) {
            addMessage("I'm listening. No matter what's happening, here is the PinkMind guide to feeling better:\n\n" + masterAdvice);
        }
    }, 1000);
}

sendBtn.addEventListener('click', handleSend);
userInput.addEventListener('keypress', (e) => { if (e.key === 'Enter') handleSend(); });
