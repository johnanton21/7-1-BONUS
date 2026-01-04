# Οδηγίες για JaCoCo Coverage - Team Members

## ⚠️ Σημαντικό!
Τα JaCoCo reports δεν κάνονται push στο Git. Κάθε μέλος της ομάδας πρέπει να τα δημιουργήσει τοπικά.

## 📋 Βήματα για να δείτε το 94% coverage:

### 1. Pull τον τελευταίο κώδικα
```bash
git pull origin main
```

### 2. Clean build + tests
```bash
mvn clean test
```
**Σημείωση:** Περιμένετε 10-15 δευτερόλεπτα μέχρι να τρέξουν όλα τα 65 tests

### 3. Δείτε το report
Ανοίξτε στον browser:
```
functions/target/site/jacoco/index.html
```

## ✅ Τι θα πρέπει να δείτε:

```
Coverage: 94%
Tests: 65 passing
Failures: 0
```

### Breakdown ανά package:
- **com.bonus71.functions.menus**: 94%
- **com.bonus71.functions.main.functions**: 93%

## 🔍 Αν δείτε χαμηλό coverage (π.χ. 11%):

### Πιθανά προβλήματα:

1. **Δεν έχετε τον τελευταίο κώδικα**
   ```bash
   git status
   git log -1  # Πρέπει να δείτε commit: "Improve JaCoCo test coverage from 69% to 94%"
   ```

2. **Παλιά compiled files**
   ```bash
   mvn clean  # Διαγράφει όλα τα target/
   mvn test   # Ξανακάνει build και tests
   ```

3. **Λάθος Java version**
   ```bash
   java -version  # Πρέπει να είναι Java 25 ή 21+
   ```

4. **Κοιτάτε λάθος module**
   - ✅ Σωστό: `functions/target/site/jacoco/index.html`
   - ❌ Λάθος: `target/site/jacoco/index.html` (root)

## 💡 Quick Verify

Τρέξτε αυτή την εντολή για γρήγορο έλεγχο:
```bash
mvn test 2>&1 | grep "Tests run:"
```

Θα πρέπει να δείτε:
```
Tests run: 65, Failures: 0, Errors: 0, Skipped: 0
```

## 📧 Support

Αν συνεχίζει να μην δουλεύει, στείλτε το output από:
```bash
mvn clean test 2>&1 | tail -30
```
