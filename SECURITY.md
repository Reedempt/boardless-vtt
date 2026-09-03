# Security Policy

## Project Status

This project is currently in **pre-alpha** development. No stable or versioned release has been published yet, and the software is not considered functional or fit for production use. As such, there is no "supported versions" table at this stage — security reports are evaluated against the current state of the `main` branch (or the project's default branch).

Once the project reaches an initial stable release, this section will be updated with a supported-versions table specifying which release lines receive security fixes.

## Reporting a Vulnerability

The security of this project is taken seriously, even at this early stage. If you discover a vulnerability, please **do not open a public issue**, as this could expose exploitable details before a fix is available.

### How to report

Please use one of the following channels, in order of preference:

1. **GitHub Private Vulnerability Reporting** (preferred): go to the [Security](../../security/advisories) tab of this repository and select "Report a vulnerability." This opens a private channel with the maintainers, integrated with GitHub Security Advisories.
2. **Email**: write to `roberto_comandatore_93@protonmail.com`, including the details listed below where possible.

### What to include in your report

To help us assess and address the issue quickly, please include, where applicable:

- A description of the vulnerability and its potential impact
- Steps to reproduce it (proof of concept, if available)
- The affected commit or branch (given the absence of released versions)
- Environment details (platform, OS, Kotlin/Gradle version, etc.)
- Any known mitigations

### What to expect

| Stage | Estimated timeline |
| --- | --- |
| Acknowledgement of receipt | within 3 business days |
| Initial assessment (triage) | within 7 business days |
| Status updates | at least every 14 days until resolution |
| Fix release (if confirmed) | depends on severity; critical issues are prioritized |

We will keep you informed throughout the process. If the vulnerability is confirmed, we will work on a fix and coordinate the public disclosure timeline with you (embargo period), unless otherwise agreed.

### Disclosure policy

We follow a **coordinated disclosure** model:

- Please do not publicly disclose the vulnerability until a fix has been released, or until otherwise agreed with the maintainers.
- Once resolved, we will publish a GitHub Security Advisory with the relevant details and, where applicable, a CVE identifier.
- Reporters who responsibly disclose a valid vulnerability will be credited in the advisory, unless they request to remain anonymous.

### Scope

The following are considered **in scope** for this policy:

- Source code contained in this repository (client/server components of the VTT, shared modules)
- Direct dependencies managed via Gradle/SQLDelight, where exploitability occurs through this project's own code

The following are generally considered **out of scope**:

- Vulnerabilities in third-party dependencies that are not exploitable through this project's code (please report these to the relevant upstream project)
- Attacks requiring physical access to a user's device
- Social engineering directed at maintainers or community members

## Security Best Practices for Contributors

- Never commit secrets, tokens, or credentials (this repository has secret scanning and push protection enabled)
- Keep dependencies up to date; Dependabot pull requests addressing security fixes should be prioritized
- Follow standard code review practices for any pull request affecting authentication, data handling, or user-facing security controls

## Contact

- Security contact: `roberto_comandatore_93@protonmail.com`
- For non-sensitive questions about the project, please open a regular public issue
