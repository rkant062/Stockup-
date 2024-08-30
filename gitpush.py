import subprocess

def automate_git_commands(commit_message):
    try:
        # Run 'git add .'
        subprocess.run(["git", "add", "."], check=True)
        print("Files added to staging area.")

        # Run 'git commit -m "Message"'
        subprocess.run(["git", "commit", "-m", commit_message], check=True)
        print(f"Committed with message: '{commit_message}'")

        # Run 'git push origin main -f'
        subprocess.run(["git", "push", "origin", "main", "-f"], check=True)
        print("Pushed changes to origin main with force.")

    except subprocess.CalledProcessError as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    commit_message = input("Enter the commit message: ")
    automate_git_commands(commit_message)
