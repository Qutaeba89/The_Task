document.addEventListener('DOMContentLoaded', function () {
    // Getting all checkboxes
    const checkboxes = document.querySelectorAll('input[type="checkbox"]');
    
    // Looping through the checkboxes and adding event listeners
    checkboxes.forEach(function(checkbox) {
        checkbox.addEventListener('change', function() {
            // Find the closest task-div element and the task label
            const taskLabel = this.closest('.task-div').querySelector('.task-left-div-top label');
            
            if (this.checked) {
                // If the checkbox is checked, add the 'completed-task' class to strikethrough the text
                taskLabel.classList.add('completed-task');
            } else {
                // If the checkbox is unchecked, remove the 'completed-task' class to remove the strikethrough
                taskLabel.classList.remove('completed-task');
            }
        });
    });
});
