#!/opt/homebrew/bin/python3
import subprocess
import sys

def automate_git_commands(commit_message):
    try:
        subprocess.run(["git", "status"], check=True)
        print("Checking status")

        subprocess.run(["git", "add", "."], check=True)
        print("Files added to staging area.")

        subprocess.run(["git", "commit", "-m", commit_message], check=True)
        print(f"Committed with message: '{commit_message}'")

        subprocess.run(["git", "push", "origin", "main", "-f"], check=True)
        print("Pushed changes to origin main with force.")

    except subprocess.CalledProcessError as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: git-automate 'commit message'")
        sys.exit(1)
    
    commit_message = sys.argv[1]
    automate_git_commands(commit_message)
