document.addEventListener('DOMContentLoaded', function () {
    // Getting all checkboxes
    const checkboxes = document.querySelectorAll('.checkbox-done');

    // Looping through the checkboxes and adding event listeners
    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener('change', function () {
            // Find the closest task-div element and the task label
            const taskDiv = this.closest('.task-div');
            const taskLabel = taskDiv.querySelector('#task-top-left-div label');
            const deadlineText = taskDiv.querySelector('.status-overdue');
            const deadlineSpan = taskDiv.querySelector('#task-bot-left-div span');

            if (this.checked) {
                // If the checkbox is checked, add the 'completed-task' class to strikethrough the text
                if (taskLabel) {
                    taskLabel.classList.add("completed-task");
                }
                taskDiv.classList.add("completed-task-background");

                if (deadlineText) {
                    deadlineText.classList.add("hidden");
                }
                if (deadlineSpan) {
                    deadlineSpan.classList.add("hidden");
                }
            } else {
                // If the checkbox is unchecked, remove the 'completed-task' class to remove the strikethrough
                if (taskLabel) {
                    taskLabel.classList.remove("completed-task");
                }
                taskDiv.classList.remove("completed-task-background");
                // If the checkbox is unchecked, remove the class "hidden" from deadline text 'Försenad' and deadline span 'yyyy-MM-dd HH:mm' deadline
                if (deadlineText) {
                    deadlineText.classList.remove("hidden");
                }
                if (deadlineSpan) {
                    deadlineSpan.classList.remove("hidden");
                }
            }
        });
    });
});

