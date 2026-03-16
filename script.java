// Simple function to simulate game start
function startGame() {
    alert("Starting 'Mindful Breathing' mini-game... Focus on the character!");
}

// Handling File Upload UI
const fileInput = document.getElementById('fileUpload');
fileInput.addEventListener('change', function() {
    if (this.files && this.files[0]) {
        alert("Resource '" + this.files[0].name + "' uploaded successfully!");
    }
});

// Basic Chat Simulation
const chatInput = document.querySelector('.chat-footer input');
const chatBtn = document.querySelector('.chat-footer button');
const chatBody = document.getElementById('chatBody');

chatBtn.addEventListener('click', () => {
    if (chatInput.value.trim() !== "") {
        const userMsg = document.createElement('p');
        userMsg.style.textAlign = "right";
        userMsg.innerHTML = `<strong>You:</strong> ${chatInput.value}`;
        chatBody.appendChild(userMsg);
        
        chatInput.value = "";
        
        // Auto-scroll
        chatBody.scrollTop = chatBody.scrollHeight;
    }
});
