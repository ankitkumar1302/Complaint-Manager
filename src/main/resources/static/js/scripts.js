function openModal(element) {
    let imageUrl = element.getAttribute('data-image-url');
    let modal = document.getElementById("imageModal");
    let modalImg = document.getElementById("modalImage");
    modal.style.display = "block";
    modalImg.src = imageUrl;
}

function closeModal() {
    let modal = document.getElementById("imageModal");
    modal.style.display = "none";
}

function toggleDarkMode() {
    document.body.classList.toggle("dark-mode");
}

function openResponseDialog(button) {
    const complaintId = button.getAttribute('data-complaint-id');
    const currentRow = button.closest('tr');

    // Toggle visibility of the response dialog
    const existingDialog = document.getElementById(`response-dialog-${complaintId}`);
    if (existingDialog) {
        existingDialog.remove();
        return;
    }

    // Create a new row for the response dialog
    const responseRow = document.createElement('tr');
    responseRow.setAttribute('id', `response-dialog-${complaintId}`);
    responseRow.innerHTML = `
        <td colspan="7">
            <div class="response-dialog">
                <div class="response-dialog-header">
                    <span>Responses</span>
                    <span class="close" onclick="closeResponseDialog(${complaintId})" style="cursor:pointer;">&times;</span>
                </div>
                <div class="response-dialog-body">
                    <div class="response-dialog-messages" id="response-messages-${complaintId}"></div>
                    <form class="response-dialog-form" onsubmit="submitResponse(event, ${complaintId})">
                        <textarea name="response_description" placeholder="Type your response..." required></textarea>
                        <button type="submit">Send</button>
                    </form>
                </div>
            </div>
        </td>
    `;

    // Insert the response dialog row after the current row
    currentRow.parentNode.insertBefore(responseRow, currentRow.nextSibling);

    // Load existing responses
    fetch(`/complaints/responses/${complaintId}`)
        .then(response => response.json())
        .then(data => {
            const messagesContainer = document.getElementById(`response-messages-${complaintId}`);
            messagesContainer.innerHTML = '';
            data.forEach(response => {
                const messageElement = document.createElement('div');
                messageElement.textContent = `${response.responseDescription} (User ID: ${response.userId})`;
                messagesContainer.appendChild(messageElement);
            });
        });
}

function closeResponseDialog(complaintId) {
    const dialog = document.getElementById(`response-dialog-${complaintId}`);
    if (dialog) {
        dialog.remove();
    }
}

function submitResponse(event, complaintId) {
    event.preventDefault();
    const form = event.target;
    const responseDescription = form.querySelector('textarea').value;

    fetch('/complaints/responses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            complaintId: complaintId,
            responseDescription: responseDescription,
            userId: 1, // Replace with the actual user ID
            responseDate: new Date().toISOString(),
        }),
    })
        .then(response => response.json())
        .then(data => {
            const messagesContainer = document.getElementById(`response-messages-${complaintId}`);
            const messageElement = document.createElement('div');
            messageElement.textContent = `${data.responseDescription} (User ID: ${data.userId})`;
            messagesContainer.appendChild(messageElement);
            form.reset();
        })
        .catch(error => console.error('Error:', error));
}
